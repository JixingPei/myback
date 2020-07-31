package com.oldpei.myback.service.impl;

import com.oldpei.myback.configs.ContantsFromYaml;
import com.oldpei.myback.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

public class PhotoServiceImpl implements PhotoService {
    @Autowired
    ContantsFromYaml contantsFromYaml;

    @Override
    public List<String> getFileDate() {
        String filePath=contantsFromYaml.getFilepath();
        if (new File(filePath).exists()){


        }else{
            return null;
        }

        return null;
    }
}
