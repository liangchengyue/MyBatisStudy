package com.lcy.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.lcy.pojo.User;
import com.lcy.pojo.UserCustom;
import com.lcy.vo.UserQuer;

public class IUserMapperTest {
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
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserByIdUser() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		IUserMapper userMapper=sqlSession.getMapper(IUserMapper.class);
		//调用userMapper的方法
		User user=userMapper.findUserById(1);
		sqlSession.close();
		System.out.println(user);
	}
	@Test
	public void testFindUserByNameUser() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		IUserMapper userMapper=sqlSession.getMapper(IUserMapper.class);
		//调用userMapper的方法
		List<User> list=userMapper.findUserByName("小明");
		sqlSession.close();
		System.out.println(list);
	}
	@Test
	public void testFindUserList() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		IUserMapper userMapper=sqlSession.getMapper(IUserMapper.class);
		//创建包装对象，设置查询条件
		UserQuer userQuer=new UserQuer();
		UserCustom userCustom=new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("张三丰");
		userQuer.setUserCustom(userCustom);
		//调用userMapper的方法
		List<UserCustom> list=userMapper.findUserList(userQuer);
		sqlSession.close();
		System.out.println(list);
	}
}
