package com.oldpei.myback.utils.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jixing.pei
 */
public class ConstantMessage {

    public static final Map<Integer, String> MAP = new HashMap<>();

    static {
        MAP.put(ConstantCode.SUCCEED_CODE,"成功后返回的code");
        MAP.put(ConstantCode.FILE_SO_BIG,"上传文件过大");
        MAP.put(ConstantCode.FILE_NAME_IS_EMPTY,"上传文件的文件名为空");
        MAP.put(ConstantCode.FILE_ERROR_FORMAT,"上传文件的格式不为jpg");
        MAP.put(ConstantCode.FILE_ALREADY_EXISTS,"上传文件已经存在");
        MAP.put(ConstantCode.FILE_CREATION_FAILED,"创建文件失败");
        MAP.put(ConstantCode.SQL_INSERT_FAILED,"插入数据失败");
    }

}
