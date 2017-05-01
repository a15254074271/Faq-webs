package com.faq.dts.controller.resp;

import java.util.List;

import com.faq.common.resp.CommonResp;
import com.faq.dts.dao.pojo.DtsEntity;

public class DtsResp extends CommonResp
{
    private List<DtsEntity> dtsList;

    public List<DtsEntity> getDtsList()
    {
        return dtsList;
    }

    public void setDtsList(List<DtsEntity> dtsList)
    {
        this.dtsList = dtsList;
    };
    
    

}
