package com.snax.vxvw.vxvwcore.util;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static Object ok(){
        Map<String,Object> obj=new HashMap<>();
        obj.put("errno",0);
        obj.put("errmsg","成功");
        return obj;
    }

    public static Object ok(Object data){
        Map<String,Object> map= (Map<String, Object>) ok();
        map.put("data",data);
        return map;
    }

    public static Object ok(String errmsg,Object data){
        Map<String,Object> map=new HashMap<>();
        map.put("errno",0);
        map.put("errmsg",errmsg);
        map.put("data",data);
        return map;
    }

    public static Object fail(){
        Map<String,Object> obj=new HashMap<>();
        obj.put("errno",-1);
        obj.put("errmsg","错误");
        return obj;
    }

    public static Object fail(int errno,String errmsg){
        Map<String,Object> map= (Map<String, Object>) fail();
        map.put("errno",errno);
        map.put("errmsg",errmsg);
        return map;
    }

    public static Object badArgument(){
        return fail(401,"参数不对");
    }

    public static Object badArgumentValue(){
        return fail(402,"参数值不对");
    }

    public static Object unlogin(){
        return fail(501,"请登录");
    }

    public static Object serious(){
        return fail(502,"系统内部错误");
    }

    public static Object unsupport(){
        return fail(503,"当前系统不支持");
    }
}
