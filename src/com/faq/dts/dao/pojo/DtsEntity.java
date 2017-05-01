package com.faq.dts.dao.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="DTS_ENTITY")
@Component
public class DtsEntity
{
    @Id
    @Column(name="DTS_ID")
    private String DTS_ID;
    @Column(name="VERSION")
    private String VERSION;
    @Column(name="MODULE")
    private String MODULE;
    @Column(name="TYPE")
    private String TYPE;
    @Column(name="DTS_TITLE")
    private String DTS_TITLE;
    @Column(name="DESCRIPTION")
    private String DESCRIPTION;
    @Column(name="QUESTIONS")
    private String QUESTIONS;
    @Column(name="REFER_WIKI")
    private String REFER_WIKI;
    @Column(name="PERSON_LIABLE")
    private String PERSON_LIABLE;
    @Column(name="REMARK")
    private String REMARK;
    @Column(name="CREATE_TIME")
    private Timestamp CREATE_TIME;
    public String getDTS_ID()
    {
        return DTS_ID;
    }
    public void setDTS_ID(String dTS_ID)
    {
        DTS_ID = dTS_ID;
    }
    public String getVERSION()
    {
        return VERSION;
    }
    public void setVERSION(String vERSION)
    {
        VERSION = vERSION;
    }
    public String getMODULE()
    {
        return MODULE;
    }
    public void setMODULE(String mODULE)
    {
        MODULE = mODULE;
    }
    public String getTYPE()
    {
        return TYPE;
    }
    public void setTYPE(String tYPE)
    {
        TYPE = tYPE;
    }
    public String getDTS_TITLE()
    {
        return DTS_TITLE;
    }
    public void setDTS_TITLE(String dTS_TITLE)
    {
        DTS_TITLE = dTS_TITLE;
    }
    public String getDESCRIPTION()
    {
        return DESCRIPTION;
    }
    public void setDESCRIPTION(String dESCRIPTION)
    {
        DESCRIPTION = dESCRIPTION;
    }
    public String getQUESTIONS()
    {
        return QUESTIONS;
    }
    public void setQUESTIONS(String qUESTIONS)
    {
        QUESTIONS = qUESTIONS;
    }
    public String getREFER_WIKI()
    {
        return REFER_WIKI;
    }
    public void setREFER_WIKI(String rEFER_WIKI)
    {
        REFER_WIKI = rEFER_WIKI;
    }
    public String getPERSON_LIABLE()
    {
        return PERSON_LIABLE;
    }
    public void setPERSON_LIABLE(String pERSON_LIABLE)
    {
        PERSON_LIABLE = pERSON_LIABLE;
    }
    public String getREMARK()
    {
        return REMARK;
    }
    public void setREMARK(String rEMARK)
    {
        REMARK = rEMARK;
    }
    public Timestamp getCREATE_TIME()
    {
        return CREATE_TIME;
    }
    public void setCREATE_TIME(Timestamp cREATE_TIME)
    {
        CREATE_TIME = cREATE_TIME;
    }
    
    
}
