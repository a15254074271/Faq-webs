package com.faq.dts.controller;

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
import com.faq.dts.controller.resp.DtsResp;
import com.faq.dts.dao.pojo.DtsEntity;
import com.faq.dts.service.DtsService;

@Controller
@RequestMapping("/dts")
public class DtsController
{
    private static final Logger Log = Logger.getLogger(DtsController.class);
    @Autowired
    private DtsService dtsService;
    
    @RequestMapping(value="queryDts",method=RequestMethod.POST)
    public void queryDts(HttpServletRequest request,HttpServletResponse response)
    {
        String dtsId = request.getParameter("dtsId");
        DtsResp resp = new DtsResp();
        if (dtsId.isEmpty()){
            resp.setRespCode("1");
            print(resp,response);
            return;
        }
        List<DtsEntity> dtsList = dtsService.queryDts(dtsId);
        
        if (dtsList.isEmpty()){
            resp.setRespCode("1");
            print(resp,response);
            return;
        }
        else
        {
            resp.setRespCode("0");
            resp.setRespMsg("success");
            resp.setDtsList(dtsList);
        }
        
        print(resp,response);
    }
    
    /**
     * 添加用户
     * @param request
     * @param response
     */
    @RequestMapping(value="addDts",method=RequestMethod.POST)
    public void addUser(HttpServletRequest request,HttpServletResponse response)
    {
        DtsEntity dtsEntity = toDtsEntity(request.getParameter("dtsEntity"));
        DtsResp resp = new DtsResp();
        if (null == dtsEntity)
        {
            resp.setRespCode("1");
            print(resp,response);
            return;
        }
        int flag = dtsService.addDts(dtsEntity);
        
   
        resp.setRespCode(String.valueOf(flag));
        
        print(resp,response);

    }
    /**
     * 更新用户
     * @param request
     * @param response
     */
    @RequestMapping(value="updateDts",method=RequestMethod.POST)
    public void updateUser(HttpServletRequest request,HttpServletResponse response)
    {
        DtsEntity dtsEntity = toDtsEntity(request.getParameter("dtsEntity"));
        DtsResp resp = new DtsResp();
        if (null == dtsEntity)
        {
            resp.setRespCode("1");
            print(resp,response);
            return;
        }
        int flag = dtsService.updateDts(dtsEntity);
        resp.setRespCode(String.valueOf(flag));
        
        print(resp,response);
    }
    
    /**
     * 删除用户
     * @param request
     * @param response
     */
    @RequestMapping(value="delDts",method=RequestMethod.POST)
    public void delUser(HttpServletRequest request,HttpServletResponse response)
    {
        DtsEntity oldDtsEntity = toDtsEntity(request.getParameter("dtsEntity"));
        DtsResp resp = new DtsResp();
        if (null == oldDtsEntity)
        {
            resp.setRespCode("1");
            print(resp,response);
            return;
        }
        int flag = dtsService.deleteDts(oldDtsEntity);
        
        resp.setRespCode(String.valueOf(flag));
        
        print(resp,response);
    }
    
    /**
     * JSON转DTS对象
     * @param struser
     * @return
     */
    private DtsEntity toDtsEntity(String struser)
    {
        Log.debug("dts : "+struser);
        JSONObject userJs = JSONObject.fromObject(struser);
        DtsEntity dtsEntity = (DtsEntity) JSONObject.toBean(userJs, DtsEntity.class);
        return dtsEntity;
        
    }
    /**
     * 将DtsResp返回给前台
     * @param dts
     * @param response
     */
    private void print(DtsResp dts,HttpServletResponse response)
    {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setResponse(response);
        ajaxResponse.write(JSONObject.fromObject(dts).toString());
    }
    
}
