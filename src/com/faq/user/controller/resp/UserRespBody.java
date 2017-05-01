package com.faq.user.controller.resp;

import java.util.List;

import com.faq.user.dao.pojo.User;


public class UserRespBody
{
    private List<User> userList;

    public UserRespBody(List<User> userList)
    {
        this.userList = userList;
    }
    
    public List<User> getUserList()
    {
        return userList;
    }

    public void setUserList(List<User> userList)
    {
        this.userList = userList;
    }
    
    
}
