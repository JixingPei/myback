package com.oldpei.myback.controller;

import com.oldpei.myback.model.CustomerPhoto;
import com.oldpei.myback.model.CustomerPhotoType;
import com.oldpei.myback.model.ResultModel;
import com.oldpei.myback.service.PhotoService;
import com.oldpei.myback.service.PhotoTypeService;
import com.oldpei.myback.utils.ConstantCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PhotoTypeController extends BaseController {
    @Autowired
    private PhotoTypeService photoTypeService;
    @Autowired
    private PhotoService photoService;

    @GetMapping("/photoType")
    public ResultModel getAllPhotoType() {
        ResultModel<CustomerPhotoType> model = new ResultModel<>();
        model.setData(photoTypeService.getAllPhotoType());
        model.setCode(ConstantCode.SUCCEED_CODE);
        return model;
    }

    @PostMapping("/photoType")
    public ResultModel addPhotoType(CustomerPhotoType photoType) {
        ResultModel<CustomerPhotoType> model = new ResultModel<>();
        int resultCode;
        resultCode = photoTypeService.addPhotoType(photoType);
        if (resultCode > 0) {
            List<CustomerPhotoType> list = model.getData();
            list.add(photoType);
            model.setData(list);
            model.setCode(ConstantCode.SUCCEED_CODE);
        } else {
            model.setCode(ConstantCode.SQL_INSERT_FAILED);
        }
        return model;
    }

    @PutMapping("/photoType")
    public ResultModel updatePhotoType(CustomerPhotoType photoType) {
        ResultModel<CustomerPhotoType> model = new ResultModel<>();
        int resultCode = photoTypeService.updatePhotoType(photoType);
        CustomerPhoto photo = new CustomerPhoto();
        photo.setType(photoType.getType());
        photo.setOldType(photoType.getOldType());
        if (resultCode > 0) {
            photoService.updateTypeOfPhoto(photo);
            List<CustomerPhotoType> list = model.getData();
            list.add(photoType);
            model.setData(list);
            model.setCode(ConstantCode.SUCCEED_CODE);
        } else {
            model.setCode(ConstantCode.SQL_UPDATE_FAILED);
        }
        return model;
    }

    @DeleteMapping("/photoType")
    public ResultModel deletePhotoType(CustomerPhotoType photoType) {
        ResultModel<CustomerPhotoType> model = new ResultModel<>();
        int resultCode = photoTypeService.deletePhotoTypeById(photoType);
        if (resultCode > 0) {
            photoService.deletePhotoByType(photoType.getType());
            List<CustomerPhotoType> list = model.getData();
            list.add(photoType);
            model.setData(list);
            model.setCode(ConstantCode.SUCCEED_CODE);
        } else {
            model.setCode(ConstantCode.SQL_UPDATE_FAILED);
        }
        return model;
    }
}
