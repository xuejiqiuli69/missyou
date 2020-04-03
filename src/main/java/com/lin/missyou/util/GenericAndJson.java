/**
 * @作者 leokkzhang
 * @创建时间 2020/4/4 0:44
 */
package com.lin.missyou.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.missyou.exception.http.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class GenericAndJson {

    private static ObjectMapper mapper;

    @Autowired
    public void setMapper(ObjectMapper mapper){
        GenericAndJson.mapper = mapper;
    }

    public static <T> String objectToJson(T o){
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    public static <T> T jsonToObject(String s, Class<T> classT) {
        if (s == null) {
            return null;
        }
        try {
            return GenericAndJson.mapper.readValue(s, classT);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
}
