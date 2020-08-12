package com.oldpei.myback.service.impl;

import com.oldpei.myback.configs.ConstantsFromYaml;
import com.oldpei.myback.dao.CustomerPhotoMapper;
import com.oldpei.myback.model.CustomerPhoto;
import com.oldpei.myback.model.CustomerPhotoType;
import com.oldpei.myback.service.PhotoService;
import com.oldpei.myback.service.PhotoTypeService;
import com.oldpei.myback.utils.CommonUtils;
import com.oldpei.myback.utils.ConstantCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author jixing.pei
 */
@Service
public class PhotoServiceImpl implements PhotoService {
    private Logger logger = LoggerFactory.getLogger(PhotoServiceImpl.class);
    @Autowired
    private CustomerPhotoMapper photoMapper;
    @Autowired
    private PhotoTypeService photoTypeService;
    @Autowired
    private ConstantsFromYaml constantsFromYaml;
    @Autowired
    private Environment environment;


    @Override
    public List<String> getFileDate() {
        String filePath = constantsFromYaml.getFilepath();
        if (new File(filePath).exists()) {
            return Arrays.asList((new File(filePath)).list());
        } else {
            return null;
        }
    }

    @Override
    public List<List> getFilePathNamrList(List<String> dateList) {
        String port = environment.getProperty("local.server.port");
        List<List> filePathNamrList = new ArrayList<>();
        List<String> tempFileList;
        String domain = constantsFromYaml.getDomain();
        for (int i = 0; i < dateList.size(); i++) {
            tempFileList = new ArrayList<>();
            List<String> tempList = Arrays.asList(new File(constantsFromYaml.getFilepath() + dateList.get(i)).list());
            if (CommonUtils.listNonNull(tempList)) {
                for (int j = 0; j < tempList.size(); j++) {
                    tempFileList.add(domain + "img/" + dateList.get(i) + "/" + tempList.get(j));
                }
            }
            filePathNamrList.add(tempFileList);
        }
        return filePathNamrList;
    }

    @Override
    public int uploadPhoto(MultipartFile file, CustomerPhoto photo) {
        int resultCode;
        // 获取文件名称
        String fileName = file.getOriginalFilename();
        resultCode = checkFiles(file);
        if (codeNotSucceed(resultCode)) {
            return resultCode;
        }
        String path = constantsFromYaml.getFilepath();
        if (CommonUtils.strIsEmpty(photo.getDate())) {
            // get current instance of the calendar
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            photo.setDate(formatter.format(calendar.getTime()));
        }
        String newPath = path + photo.getDate() + "/";
        String newFilePathName = newPath + fileName;
        resultCode = createFiles(newFilePathName, file);
        if (codeNotSucceed(resultCode)) {
            return resultCode;
        }
        photo.setName(fileName);
        photo.setStorage(newFilePathName);
        String domain = constantsFromYaml.getDomain();
        photo.setPath(domain + "img/" + photo.getDate() + "/" + fileName);
        resultCode = insertWithoutUniqueId(photo) > 0 ? ConstantCode.SUCCEED_CODE : ConstantCode.SQL_INSERT_FAILED;
        return resultCode;
    }


    @Override
    public List<String> getPhotoWall() {
        String port = environment.getProperty("local.server.port");
        List<String> fileList = new ArrayList<>();
        List<String> tempList;
        String path = constantsFromYaml.getFilepath() + "photowall";
        File filePath = new File(path);
        String domain = constantsFromYaml.getDomain();
        if (Objects.nonNull(filePath.list())) {
            tempList = Arrays.asList(filePath.list());
            for (String fileName : tempList
            ) {
                fileList.add(domain + "img/" + "photowall/" + fileName);
            }
        }
        return fileList;
    }

    @Override
    public int insertWithoutUniqueId(CustomerPhoto record) {
        return photoMapper.insertWithoutUniqueId(record);
    }

    @Override
    public List<CustomerPhoto> getAllPhoto() {
        return photoMapper.getAllPhoto();
    }

    @Override
    public Map<String, List<CustomerPhoto>> orderByType(List<CustomerPhoto> photoList) {
        List<CustomerPhotoType> typeList = photoTypeService.getAllPhotoType();
        Map<String, List<CustomerPhoto>> map = new HashMap<>(typeList.size() + 1);
        for (CustomerPhotoType photoType : typeList
        ) {
            map.put(photoType.getType(), new ArrayList<>());
        }
        map.put("空", new ArrayList<>());
        for (CustomerPhoto photo :
                photoList
        ) {
            if (CommonUtils.strIsEmpty(photo.getType())) {
                map.get("空").add(photo);
            } else {
                if (Objects.nonNull(map.get(photo.getType()))) {
                    map.get(photo.getType()).add(photo);
                }
            }
        }
        return map;
    }

    @Override
    public int updateTypeOfPhoto(CustomerPhoto photo) {
        return photoMapper.updateTypeOfPhoto(photo);
    }

    @Override
    public int deletePhotoByType(String type) {
        List<CustomerPhoto> photoList = photoMapper.getPhotoByType(type);
        int result = 0;
        try {
            for (CustomerPhoto photo : photoList
            ) {
                result = photoMapper.deleteByPrimaryKey(photo.getUniqueId());
                deleteFile(photo.getStorage());
            }
        } catch (Exception e) {
            logger.error("", e);
            result = -1;
        }
        return result;
    }

    public boolean deleteFile(String filePathName) {
        File file = new File(filePathName);
        if (file.exists()) {
            file.delete();
        }
        return true;
    }

    public int createFiles(String newFilePathName, MultipartFile file) {
        File newFile = new File(newFilePathName);
        if (!newFile.exists()) {
//            创建文件夹
            newFile.mkdirs();
        } else {
            return ConstantCode.FILE_ALREADY_EXISTS;
        }
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            logger.error("创建文件失败", e);
            return ConstantCode.FILE_CREATION_FAILED;
        }
        return ConstantCode.SUCCEED_CODE;
    }


    public boolean codeNotSucceed(int code) {
        if (code == ConstantCode.SUCCEED_CODE) {
            return false;
        } else {
            return true;
        }
    }

    public int checkFiles(MultipartFile file) {
        int resultCode;
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        if (CommonUtils.strIsEmpty(fileName)) {
            resultCode = ConstantCode.FILE_NAME_IS_EMPTY;
            return resultCode;
        }
        // 获取文件的大小
        long fileSize = file.getSize();
        if (fileSize > 1024 * 1024 * 10) {
            resultCode = ConstantCode.FILE_SO_BIG;
            return resultCode;
        }
        //获取文件的扩展名
        String extension = CommonUtils.getFileExtension(fileName);
        if (!extension.equals("jpg")) {
            resultCode = ConstantCode.FILE_ERROR_FORMAT;
            return resultCode;
        }
        resultCode = ConstantCode.SUCCEED_CODE;
        return resultCode;
    }

}
