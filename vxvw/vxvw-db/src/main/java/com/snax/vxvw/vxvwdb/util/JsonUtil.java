package com.snax.vxvw.vxvwdb.util;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.annotation.AnnotationUtils;

import java.io.OutputStream;

/**
 * fasterxml.jackson的工具类
 */
public class JsonUtil {
    private static Log log=LogFactory.getLog(JsonUtil.class);
    private static final ObjectMapper mapper=new ObjectMapper();

    public static String toJSONString(Object object){
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(),e);
        }
        return null;
    }

    public static String toJSONString(Object o,String... properties){
        try {
            return mapper.writer(new SimpleFilterProvider().addFilter(
                    AnnotationUtils.getValue(
                            AnnotationUtils.findAnnotation(o.getClass(),JsonFilter.class)
                    ).toString(),
                    SimpleBeanPropertyFilter.filterOutAllExcept(properties)
            )).writeValueAsString(o);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(),e);
        }
        return null;
    }

    public static void toJSONString(OutputStream out,Object o,String... properties){
        try {
            mapper.writer(new SimpleFilterProvider().addFilter(
                    AnnotationUtils.getValue(
                            AnnotationUtils.findAnnotation(
                                    o.getClass(),JsonFilter.class
                            )).toString(),
                    SimpleBeanPropertyFilter.filterOutAllExcept(properties)
            )).writeValue(out,o);
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
    }

    public static <T> T parse(String json,Class<T> clazz){
        if (json==null||json.isEmpty()){
            return null;
        }

        try {
            return mapper.readValue(json,clazz);
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
        return null;
    }
}
