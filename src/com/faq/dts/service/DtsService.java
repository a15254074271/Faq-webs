package com.faq.dts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faq.dts.dao.DtsDao;
import com.faq.dts.dao.pojo.DtsEntity;


@Repository
public class DtsService
{
    @Autowired
    private DtsDao dtsDao;
    
    public List<DtsEntity> queryDts(String Dtsid)
    {
        return dtsDao.queryDts(Dtsid);
    }
    public int addDts(DtsEntity dtsEntity)
    {
        return dtsDao.addDts(dtsEntity);
    }
    //删除DtsEntity操作,返回码1表示删除成功，返回-1表示删除失败
    public int deleteDts(DtsEntity dtsEntity)
    {
        return dtsDao.deleteDts(dtsEntity);
    }

    //更新DtsEntity操作,返回码1表示更新成功，返回-1表示更新失败   
    public int updateDts(DtsEntity dtsEntity)
    {
        return dtsDao.updateDts(dtsEntity);
    }
}
