package com.lcy.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.lcy.pojo.User;

public class UserDaoImplTest {
	private SqlSessionFactory sqlSessionFactory;

	// 此方法是在执行testFindUserByIdUser之前执行
	@Before
	public void setUp() throws Exception {
		// 创建SqlSessionFactory
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
	}

	@Test
	public void testFindUserByIdUser() throws Exception {
		//创建UserDao对象
		IUserDao userDao=new UserDaoImpl(sqlSessionFactory);
		//调用UserDao的方法
		User user= userDao.findUserByIdUser(1);
		System.out.println(user);
	}

}
