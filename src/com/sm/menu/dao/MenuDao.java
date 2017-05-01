package com.sm.menu.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sm.menu.dao.pojo.MenuEntity;

@Repository
public class MenuDao
{
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 添加菜单
     */
    public int addMenu(MenuEntity menu)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Transaction ts = session.getTransaction();
        try
        {
            session.save(menu);
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
     * 通过Menu对象查询
     */
    public List<MenuEntity> queryMenu(MenuEntity menu)
    {
        Session session = sessionFactory.openSession();
        String hql = "from MenuEntity where '1'='1'";
        if (null != menu)
        {
            if (!menu.getMENU_ID().equals("") && menu.getMENU_ID() != null)
            {
                hql = hql + " and menuId=:menuId";
            }
        }
        Query query = session.createQuery(hql);
        if (null != menu)
        {
            if (!menu.getMENU_ID().equals("") && menu.getMENU_ID() != null)
            {
                query.setParameter("menuId", menu.getMENU_ID());
            }
        }
        @SuppressWarnings("unchecked")
        List<MenuEntity> menuList = query.list();
        session.close();
        return menuList;
    }


    /**
     * 更新菜单
     */
    public int updateMenu(MenuEntity menu){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Transaction ts = session.getTransaction();
        session.update(menu);
        ts.commit();
        return 1;
    }

    /**
     * 通过name,删除用户
     */
    public int deleteMenu(MenuEntity menu){
        Session session = sessionFactory.openSession();
        Transaction ts = session.getTransaction();
        ts.begin();
        session.delete(menu);
        ts.commit();
        session.close();
        return 1;
    }

}
