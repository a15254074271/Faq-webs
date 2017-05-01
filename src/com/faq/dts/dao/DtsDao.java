package com.faq.dts.dao;

import java.util.List;
import javax.transaction.Transaction;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faq.dts.dao.pojo.DtsEntity;

@Repository
public class DtsDao
{
    private static final Logger Log = Logger.getLogger(DtsDao.class);
    @Autowired
    private SessionFactory sessionFactory;

    //添加DtsEntity操作,返回码1表示添加成功，返回-1表示添加失败
    public int addDts(DtsEntity dtsEntity)
    {
        Log.debug("DtsDao.addDts.start...");
        Log.debug("DtsDao.addDts.DtsEntity is : "+ JSONObject.fromObject(dtsEntity).toString());
        Session session = sessionFactory.openSession();
        Transaction ts=(Transaction) session.beginTransaction();
        try
        {
            session.save(dtsEntity);
            ts.commit();
            return 1;
        } catch (Exception e)
        {
            try
            {
                ts.rollback();
            } catch (Exception e1)
            {
                e1.printStackTrace();
            }
            e.printStackTrace();
            return -1;
        }
        finally
        {
            session.close();
        }       
    }

    //删除DtsEntity操作,返回码1表示删除成功，返回-1表示删除失败
    public int deleteDts(DtsEntity dtsEntity)
    {
        Log.debug("DtsDao.deleteDts.start...");
        Log.debug("DtsDao.deleteDts.DtsEntity is : "+ dtsEntity);
        Session session = sessionFactory.openSession();
        Transaction ts=(Transaction) session.beginTransaction();
        try
        {
            session.delete(dtsEntity);
            ts.commit();
            return 1;
        } catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
        finally
        {
            session.close();
        }  
    }

    //更新DtsEntity操作,返回码1表示更新成功，返回-1表示更新失败   
    public int updateDts(DtsEntity dtsEntity)
    {
        Log.debug("DtsDao.updateDts.start...");
        Log.debug("DtsDao.updateDts.DtsEntity is : "+ JSONObject.fromObject(dtsEntity).toString());
        Session session = sessionFactory.openSession();
        Transaction ts=(Transaction) session.beginTransaction();
        try
        {
            session.update(dtsEntity);
            ts.commit();
            return 1;
        } catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
        finally
        {
            session.close();
        } 
    }

    //通过Dtsid查询DtsEntity 返回一个list
    public List<DtsEntity> queryDts(String Dtsid)
    {
        Session session = sessionFactory.openSession();
        String hql = "from DtsEntity where DTS_ID=:dtsid";
        Query query = session.createQuery(hql);
        query.setParameter("dtsid", Dtsid);
        query.iterate();
        @SuppressWarnings("unchecked")
        List<DtsEntity> userList = query.list();
        session.close();
        return userList;
    }


    //通过Dtsid查询DtsEntity 返回一个DtsEntity对象
    public DtsEntity getDtsById(String Dtsid)
    {
        Log.debug("DtsDao.getByIdDts.start...");
        Log.debug("DtsDao.getByIdDts.DtsEntity is : "+ Dtsid);
        Session session = sessionFactory.openSession();
        Transaction ts=(Transaction) session.beginTransaction();
        DtsEntity dtsEntity=null;
        try
        {
            dtsEntity=(DtsEntity) session.get(DtsEntity.class, Dtsid);
            ts.commit();
            return dtsEntity;
        } catch (Exception e)
        {
            e.printStackTrace();
            Log.debug("DtsDao.getDtsById.DtsEntity is : "+ JSONObject.fromObject(dtsEntity).toString());
            return null;
        }
        finally
        {
            session.close();
        }  
    }
}
