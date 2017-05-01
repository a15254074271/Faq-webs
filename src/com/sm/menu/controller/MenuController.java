package com.sm.menu.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.faq.base.AjaxResponse;
import com.faq.user.controller.resp.UserResp;
import com.sm.menu.controller.pojo.MenuResp;
import com.sm.menu.dao.pojo.MenuEntity;
import com.sm.menu.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController
{   
    private static final Logger Log = Logger.getLogger(MenuController.class);
    @Autowired
    private MenuService menuService;
    /**
     * 添加用户
     * @param request
     * @param response
     */
    @RequestMapping(value="addMenu",method=RequestMethod.POST)
    public void addMenu(HttpServletRequest request,HttpServletResponse response)
    {
    	MenuEntity newMenu = toMenu(request.getParameter("menu"));
        int flag = menuService.addMenu(newMenu);
        
        UserResp resp = new UserResp();
        resp.setRespCode(String.valueOf(flag));
        
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setResponse(response);
        ajaxResponse.write(JSONObject.fromObject(resp).toString());

    }
    /**
     * 查询用户
     * @param request
     * @param response
     */
    @RequestMapping(value="queryMenu",method=RequestMethod.POST)
    public void queryMenu(HttpServletRequest request,HttpServletResponse response)
    {
    	MenuEntity queryMenu = toMenu(request.getParameter("menu"));
        List<MenuEntity> user = menuService.queryMenu(queryMenu);
        MenuResp resp = new MenuResp();
        resp.setMenuList(user);
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setResponse(response);
        ajaxResponse.write(JSONObject.fromObject(resp).toString());
    }
    /**
     * 更新用户
     * @param request
     * @param response
     */
    @RequestMapping(value="updateMenu",method=RequestMethod.POST)
    public void updateMenu(HttpServletRequest request,HttpServletResponse response)
    {
    	MenuEntity newMenu = toMenu(request.getParameter("user"));
        
        int flag = menuService.updateMenu(newMenu);
        UserResp resp = new UserResp();
        resp.setRespCode(String.valueOf(flag));
        
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setResponse(response);
        ajaxResponse.write(JSONObject.fromObject(resp).toString());
    }
    
    /**
     * 删除用户
     * @param request
     * @param response
     */
    @RequestMapping(value="delMenu",method=RequestMethod.POST)
    public void delMenu(HttpServletRequest request,HttpServletResponse response)
    {
    	MenuEntity oldMenu = toMenu(request.getParameter("user"));
        
        int flag = menuService.delMenu(oldMenu);
        
        UserResp resp = new UserResp();
        resp.setRespCode(String.valueOf(flag));
        
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setResponse(response);
        ajaxResponse.write(JSONObject.fromObject(resp).toString());
    }
    
    /**
     * JSON转User对象
     * @param struser
     * @return
     */
    private MenuEntity toMenu(String struser)
    {
        Log.debug("user: "+struser);
        JSONObject userJs = JSONObject.fromObject(struser);
        MenuEntity newMenu = (MenuEntity) JSONObject.toBean(userJs, MenuEntity.class);
        return newMenu;
        
    }

}
