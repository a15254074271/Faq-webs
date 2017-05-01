package com.faq.base;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;


public class JsonToBean
{
    private static final Logger Log = Logger.getLogger(JsonToBean.class);
    
    public static Object ToBean(Object obj,String json)
    {
        Log.debug(obj.getClass().toString()+" : "+json);
        JSONObject userJs = JSONObject.fromObject(json);
        obj = JSONObject.toBean(userJs, obj.getClass());
        return obj;
        
    }
}
