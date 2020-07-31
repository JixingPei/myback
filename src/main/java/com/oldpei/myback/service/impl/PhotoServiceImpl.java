package com.oldpei.myback.service.impl;

import com.oldpei.myback.configs.ContantsFromYaml;
import com.oldpei.myback.service.PhotoService;
import com.oldpei.myback.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
