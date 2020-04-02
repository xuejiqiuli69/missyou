/**
 * @作者 leokkzhang
 * @创建时间 2020/4/2 22:32
 */
package com.lin.missyou.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import java.util.Map;

public class MapAndJson implements AttributeConverter<Map<String,Object>,String> {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public String convertToDatabaseColumn(Map<String, Object> stringObjectMap) {
        try{
            return mapper.writeValueAsString(stringObjectMap);
        }catch (Exception e){
            return e.toString();
        }

    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String s) {
        return null;
    }
}
