package com.oldpei.myback.service.impl;

import com.oldpei.myback.configs.ContantsFromYaml;
import com.oldpei.myback.service.PhotoService;
import com.oldpei.myback.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    ContantsFromYaml contantsFromYaml;

    @Override
    public List<String> getFileDate() {
        String filePath = contantsFromYaml.getFilepath();
        if (new File(filePath).exists()) {
            return Arrays.asList((new File(filePath)).list());
        } else {
            return null;
        }
    }

    @Override
    public List<List> getFilePathNamrList(List<String> dateLiat) {
        List<List> filePathNamrList = new ArrayList<>();
        List<String> tempFileList;
        for (int i = 0; i < dateLiat.size(); i++) {
            tempFileList = new ArrayList<>();
            List<String> tempList = Arrays.asList(new File(contantsFromYaml.getFilepath() + dateLiat.get(i)).list());
            if (CommonUtils.listNonNull(tempList)) {
                for (int j = 0; j < tempList.size(); j++) {
                    tempFileList.add("http://localhost:8888/img/" + dateLiat.get(i) + "/" + tempList.get(j));
                }
            }
            filePathNamrList.add(tempFileList);
        }
        return filePathNamrList;
    }

    @Override
    public void uploadPhoto(MultipartFile file) {
// 获取文件名称
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        if (CommonUtils.strIsEmpty(fileName)) {
//            return jsonfailed("文件不能为空");
        }
        // 获取文件的大小
        long fileSize = file.getSize();
        if (fileSize > 10 * 1024 * 1024) {
//            return jsonfailed("上传文件大小超出限定大小10M");
        }
        // 获取文件的扩展名
        // String extension = FilenameUtils.getExtension(fileName);
        // 获取配置路径
        String path = contantsFromYaml.getFilepath();

        Calendar calendar = Calendar.getInstance();
        // get current instance of the calendar
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String today = formatter.format(calendar.getTime());
        String newPath = path + today + "\\";
        File newDir = new File(newPath);
        if (!newDir.exists()) {
            newDir.mkdirs(); // 目录不存在的情况下，创建目录
        }
        File newFile = new File(newDir, fileName);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）

        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
