package com.sm.menu.controller.pojo;

import java.util.List;

import com.faq.common.resp.CommonResp;
import com.sm.menu.dao.pojo.MenuEntity;

public class MenuResp extends CommonResp
{
	private List<MenuEntity> menuList;

	public List<MenuEntity> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<MenuEntity> menuList) {
		this.menuList = menuList;
	}
	
	
	
}
