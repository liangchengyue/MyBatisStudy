package com.lcy.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.lcy.pojo.User;

public class MyBatisFirst {
	// 根据id查询用户信息，得到一条记录结果
	@Test
	public void findUserByIdTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		// 通过工厂得到SQLSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过SQLSession操作数据库
		// 第一个参数：映射文件中statement的id，等于=namespace+"."+statem的id
		// 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		// sqlSession.selectOne结果是与映射文件中所匹配的resultType类型的对象
		// selectOne：查询一条记录
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		// 释放资源
		sqlSession.close();
	}

	@Test
	public void findUserByName() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		// 通过工厂得到SQLSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// list中的user和映射文件中resultType所指定的类型一致
		List<User> list = sqlSession.selectList("test.findUserByName", "小明");
		System.out.println(list);
		sqlSession.close();
	}
	@Test
	public void insertUser() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		// 通过工厂得到SQLSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// list中的user和映射文件中resultType所指定的类型一致
		User user=new User();
		user.setUsername("王小丫");
		user.setSex("女");
		user.setBirthday(new Date());
		user.setAddress("贵州贵阳");
		sqlSession.insert("test.insertUser", user);
		//提交事务
		sqlSession.commit();
		//获取用户信息主键
		System.out.println(user.getId());
		sqlSession.close();
	}
}
