package com.oldpei.myback.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PhotoService {
    List<String> getFileDate();
}
