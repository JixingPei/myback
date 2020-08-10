package com.oldpei.myback.controller;

import com.oldpei.myback.model.CustomerPhotoType;
import com.oldpei.myback.model.ResultModel;
import com.oldpei.myback.service.PhotoTypeService;
import com.oldpei.myback.utils.constant.ConstantCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PhotoTypeController extends BaseController {
    @Autowired
    private PhotoTypeService photoTypeService;

    @GetMapping("/photoType")
    public ResultModel getAllPhotoType() {
        ResultModel<CustomerPhotoType> model = new ResultModel<CustomerPhotoType>();
        model.setData(photoTypeService.getAllPhotoType());
        model.setCode(ConstantCode.SUCCEED_CODE);
        return model;
    }

    @PostMapping("/photoType")
    public ResultModel addPhotoType(CustomerPhotoType photoType) {
        ResultModel<CustomerPhotoType> model = new ResultModel<>();
        int resultCode = 0;
        resultCode = photoTypeService.addPhotoType(photoType);
        if (resultCode > 0) {
            model.getData().add(photoType);
            model.setCode(ConstantCode.SUCCEED_CODE);
        } else {
            model.setCode(ConstantCode.SQL_INSERT_FAILED);
        }
        return model;
    }
}
