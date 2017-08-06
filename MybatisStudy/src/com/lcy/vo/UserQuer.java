package com.lcy.vo;

import java.util.List;

import com.lcy.pojo.UserCustom;

/**
 * 包装类型
 * 
 * @author 梁城月
 * 
 */
public class UserQuer {
	private UserCustom userCustom;
	private List<Integer> ids;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

}
