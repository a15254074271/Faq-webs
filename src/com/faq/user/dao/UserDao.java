package com.faq.user.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faq.user.dao.pojo.User;

@Repository
public class UserDao
{
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 添加用户
     */
    public int addUser(User user)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Transaction ts = session.getTransaction();
        try
        {
            session.save(user);
            ts.commit();
            return 1;
        } catch (Exception e)
        {
            ts.rollback();
            return -1;
        }finally
        {
            session.close();
        }
    }

    /**
     * 通过User对象查询
     */
    public List<User> queryUser(User user)
    {
        Session session = sessionFactory.openSession();
        String hql = "from User where '1'='1'";
        if (null != user)
        {
            if (!user.getName().equals("") && user.getName() != null)
            {
                hql = hql + " and name=:name";
            }
            if (!user.getSex().equals("") && user.getSex() != null)
            {
                hql = hql + " and sex=:sex";
            }
        }
        Query query = session.createQuery(hql);
        if (null != user)
        {
            if (!user.getName().equals("") && user.getName() != null)
            {
                query.setParameter("name", user.getName());
            }
            if (!user.getSex().equals("") && user.getSex() != null)
            {
                query.setParameter("sex", user.getSex());
            }
        }
        @SuppressWarnings("unchecked")
        List<User> userList = query.list();
        session.close();
        return userList;
    }


    /**
     * 更新用户
     */
    public int updateUser(User user){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Transaction ts = session.getTransaction();
        session.update(user);
        ts.commit();
        return 1;
    }

    /**
     * 通过name,删除用户
     */
    public int deleteUser(User user){
        Session session = sessionFactory.openSession();
        Transaction ts = session.getTransaction();
        ts.begin();
        session.delete(user);
        ts.commit();
        session.close();
        return 1;
    }

}
