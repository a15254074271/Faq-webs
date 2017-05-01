package com.faq.user.controller.resp;

import com.faq.common.resp.CommonResp;

public class UserResp extends CommonResp
{
    private UserRespBody body;

    public UserRespBody getBody()
    {
        return body;
    }

    public void setBody(UserRespBody body)
    {
        this.body = body;
    }
    
    

}
