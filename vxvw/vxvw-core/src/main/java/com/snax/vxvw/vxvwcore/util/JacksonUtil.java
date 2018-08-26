package com.snax.vxvw.vxvwcore.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JacksonUtil {
    private static JacksonUtil ourInstance = new JacksonUtil();

    public static JacksonUtil getInstance() {
        return ourInstance;
    }

    private JacksonUtil() {
    }

    /**
     * 将field提取出来，并将该部分转化成json
     * @param body
     * @param field
     * @return
     */
    public String parseString(String body,String field){
        ObjectMapper mapper=new ObjectMapper();
        JsonNode node=null;
        try {
            node=mapper.readTree(body);
            JsonNode leaf=node.get(field);
            if (leaf!=null){
                return leaf.asText();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer parseInteger(String body,String field){
        ObjectMapper mapper=new ObjectMapper();
        JsonNode node=null;
        try {
            node=mapper.readTree(body);
            JsonNode leaf=node.get(field);
            if (leaf!=null){
                return leaf.asInt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Integer> parseIntegerList(String body,String field){
        ObjectMapper mapper=new ObjectMapper();
        JsonNode node=null;
        try {
            node=mapper.readTree(body);
            JsonNode leaf=node.get(field);
            if (leaf!=null){
                //使用类型引用对象，转换
                return mapper.convertValue(leaf,new TypeReference<List<Integer>>(){});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Boolean parseBoolean(String body, String field) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = null;
        try {
            node = mapper.readTree(body);
            JsonNode leaf = node.get(field);
            if(leaf != null)
                return leaf.asBoolean();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Short parseShort(String body, String field) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = null;
        try {
            node = mapper.readTree(body);
            JsonNode leaf = node.get(field);
            if(leaf != null) {
                Integer value = leaf.asInt();
                return value.shortValue();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Byte parseByte(String body, String field) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = null;
        try {
            node = mapper.readTree(body);
            JsonNode leaf = node.get(field);
            if(leaf != null) {
                Integer value = leaf.asInt();
                return value.byteValue();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T parseObject(String body,String field,Class<T> clazz){
        ObjectMapper mapper=new ObjectMapper();
        JsonNode node=null;
        try {
            node=mapper.readTree(body);
            JsonNode leaf=node.get(field);
            if (leaf!=null){
                return mapper.treeToValue(leaf,clazz);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object toNode(String json){
        if (json==null){
            return null;
        }
        ObjectMapper mapper=new ObjectMapper();
        try {
            JsonNode node=mapper.readTree(json);
            return node;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
