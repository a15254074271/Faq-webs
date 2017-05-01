package com.faq.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faq.user.dao.UserDao;
import com.faq.user.dao.pojo.User;

@Repository
public class UserService
{
//    private static final Logger Log = Logger.getLogger(UserService.class);
    @Autowired
    private UserDao userDao;
    
    public int addUser(User user)
    {
        return userDao.addUser(user);
        
    }
    
    public List<User> queryUser(User user)
    {
        return userDao.queryUser(user);
        
    }
    
    public int updateUser(User user)
    {
        return userDao.updateUser(user);
        
    }
    
    public int delUser(User user)
    {
        return userDao.deleteUser(user);
        
    }

}
