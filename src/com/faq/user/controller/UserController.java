package com.faq.user.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.faq.base.AjaxResponse;
import com.faq.user.controller.resp.UserResp;
import com.faq.user.controller.resp.UserRespBody;
import com.faq.user.dao.pojo.User;
import com.faq.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController
{   
    private static final Logger Log = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    /**
     * 添加用户
     * @param request
     * @param response
     */
    @RequestMapping(value="addUser",method=RequestMethod.POST)
    public void addUser(HttpServletRequest request,HttpServletResponse response)
    {
        User newUser = toUser(request.getParameter("user"));
        int flag = userService.addUser(newUser);
        
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
    @RequestMapping(value="queryUser",method=RequestMethod.POST)
    public void queryUser(HttpServletRequest request,HttpServletResponse response)
    {
        User queryUser = toUser(request.getParameter("user"));
        List<User> user = userService.queryUser(queryUser);
        
        UserResp resp = new UserResp();
        if(user.size()>0){
            resp.setRespCode("0");
            resp.setBody(new UserRespBody(user));
        }
        else
        {
            resp.setRespCode("1");
        }
        
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setResponse(response);
        ajaxResponse.write(JSONObject.fromObject(resp).toString());
    }
    /**
     * 更新用户
     * @param request
     * @param response
     */
    @RequestMapping(value="updateUser",method=RequestMethod.POST)
    public void updateUser(HttpServletRequest request,HttpServletResponse response)
    {
        User newUser = toUser(request.getParameter("user"));
        
        int flag = userService.updateUser(newUser);
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
    @RequestMapping(value="delUser",method=RequestMethod.POST)
    public void delUser(HttpServletRequest request,HttpServletResponse response)
    {
        User oldUser = toUser(request.getParameter("user"));
        
        int flag = userService.delUser(oldUser);
        
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
    private User toUser(String struser)
    {
        Log.debug("user: "+struser);
        JSONObject userJs = JSONObject.fromObject(struser);
        User newUser = (User) JSONObject.toBean(userJs, User.class);
        return newUser;
        
    }

}
