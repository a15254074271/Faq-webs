package com.faq.base;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class AjaxResponse
{
    private static final Logger Log = Logger.getLogger(AjaxResponse.class);
    private HttpServletResponse response;
    
    public AjaxResponse(HttpServletResponse response)
    {
        this.response = response;
    }
    public AjaxResponse()
    {
    }
    
    public HttpServletResponse getResponse()
    {
        return response;
    }

    public void setResponse(HttpServletResponse response)
    {
        this.response = response;
    }

    public void write(Object date)
    {
        if(response == null)
        {
            return;
        }
        try
        {
            response.setCharacterEncoding("UTF-8");
            if(date instanceof String ){
                Log.debug("response object type is String : "+ date);
                response.getWriter().write((String)date);
            }
            if(date instanceof Integer ){
                Log.debug("response object type is Integer : "+ date);
                response.getWriter().write((Integer) date);
            }
            if(date instanceof Character ){
                Log.debug("response object type is Character : "+ date);
                response.getWriter().write((Character) date);
            }
        } catch (IOException e)
        {
            Log.error("response Write error : "+ e);
            e.printStackTrace();
        }

    }
}