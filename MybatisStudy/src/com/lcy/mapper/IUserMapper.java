package com.lcy.mapper;

import java.util.List;

import com.lcy.pojo.User;

public interface IUserMapper {
	// 根据id查询用户信息
	public User findUserById(int id) throws Exception;

	// 添加用户信息
	public void insertUser(User user) throws Exception;

	// 删除用户信息
	public void deleteUser(int id) throws Exception;

	// 根据用户名查询用户
	public List<User> findUserByName(String name) throws Exception;
}
