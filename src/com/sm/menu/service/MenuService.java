package com.sm.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sm.menu.dao.MenuDao;
import com.sm.menu.dao.pojo.MenuEntity;

@Repository
public class MenuService
{
//    private static final Logger Log = Logger.getLogger(UserService.class);
    @Autowired
    private MenuDao menuDao;
    
    public int addMenu(MenuEntity menu)
    {
        return menuDao.addMenu(menu);
        
    }
    
    public List<MenuEntity> queryMenu(MenuEntity Menu)
    {
        return menuDao.queryMenu(Menu);
        
    }
    
    public int updateMenu(MenuEntity Menu)
    {
        return menuDao.updateMenu(Menu);
        
    }
    
    public int delMenu(MenuEntity Menu)
    {
        return menuDao.deleteMenu(Menu);
        
    }

}
