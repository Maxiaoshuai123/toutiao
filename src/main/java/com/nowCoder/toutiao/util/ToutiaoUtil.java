package com.nowCoder.toutiao.util;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.nowCoder.toutiao.controller.LoginController;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.logging.Logger;

/*工具类*/
public class ToutiaoUtil {
    /*导入日志*/
    private static final Logger logger = LoggerFactory.getLogger(ToutiaoUtil.class)

    public static String getJSONString(int code) {
        JSONPObject json = new JSONPObject();
        json.put("code", code);
        return json.toString();
    }

    public static String getJSONString(int code, String msg) {
        JSONPObject json = new JSONPObject();
        json.put("code", code);
        json.put("msg", msg);
        return json.toString();
    }

    public static String getJSONString(int code, Map<String, Object>map) {
        JSONPObject json = new JSONPObject();
        json.put("code", code);
        for (Map.Entry<String,Object> entry : map.entrySet()) {
            json.put(entry.getKey(), entry.getValue());
        }
        return json.toString();
    }


    /*MD5方法登录密码加密*/
}
