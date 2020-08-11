package com.oldpei.myback.model;

import com.oldpei.myback.utils.ConstantMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author jixing.pei
 */
public class ResultModel<T> {

    private int code;
    private String message;
    private List<T> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
        this.setMessage(ConstantMessage.MAP.get(code));
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        if (Objects.isNull(data)) {
            return new ArrayList<T>();
        }
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
