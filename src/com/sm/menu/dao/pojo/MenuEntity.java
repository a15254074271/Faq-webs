package com.sm.menu.dao.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="FAQ_MENU")
@Component
public class MenuEntity
{
	@Id
    @Column(name="MENU_ID")
    private String MENU_ID;
    @Column(name="MENU_NAME")
    private String MENU_NAME;
    @Column(name="MENU_LOGIC_PATH")
    private String MENU_LOGIC_PATH;
    @Column(name="MENU_PHYSICS_PATH")
    private String MENU_PHYSICS_PATH;
    @Column(name="CONTROLLER_NAME")
    private String CONTROLLER_NAME;
    @Column(name="DESCRIPTION")
    private String DESCRIPTION;
    @Column(name="CREATE_TIME")
    private Timestamp CREATE_TIME;
	public String getMENU_ID() {
		return MENU_ID;
	}
	public void setMENU_ID(String mENU_ID) {
		MENU_ID = mENU_ID;
	}
	public String getMENU_NAME() {
		return MENU_NAME;
	}
	public void setMENU_NAME(String mENU_NAME) {
		MENU_NAME = mENU_NAME;
	}
	public String getMENU_LOGIC_PATH() {
		return MENU_LOGIC_PATH;
	}
	public void setMENU_LOGIC_PATH(String mENU_LOGIC_PATH) {
		MENU_LOGIC_PATH = mENU_LOGIC_PATH;
	}
	public String getMENU_PHYSICS_PATH() {
		return MENU_PHYSICS_PATH;
	}
	public void setMENU_PHYSICS_PATH(String mENU_PHYSICS_PATH) {
		MENU_PHYSICS_PATH = mENU_PHYSICS_PATH;
	}
	public String getCONTROLLER_NAME() {
		return CONTROLLER_NAME;
	}
	public void setCONTROLLER_NAME(String cONTROLLER_NAME) {
		CONTROLLER_NAME = cONTROLLER_NAME;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public Timestamp getCREATE_TIME() {
		return CREATE_TIME;
	}
	public void setCREATE_TIME(Timestamp cREATE_TIME) {
		CREATE_TIME = cREATE_TIME;
	}
    
    
}

