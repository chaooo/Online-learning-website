package top.chao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.TestCase;
import top.chao.RunUserBoot;
import top.chao.dao.UserMapper;
import top.chao.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=RunUserBoot.class)
public class TestUserMapper {
	
	@Autowired
	private UserMapper userDao;
	
	@Test
	public void test1() {
		System.out.println("--------test1----------");
	}
	
	@Test
	public void test2() {
		User user = userDao.selectByName("paopao");
		System.out.println(user.getNick_name());
		//Assert.assertNotNull(user);//Assert已过时
		TestCase.assertNotNull(user);
	}
	
	@Test
	public void test3() {
		User user = userDao.selectByPrimaryKey(1);
		System.out.println(user.getName());
		//Assert.assertNotNull(user);//Assert已过时
		TestCase.assertNotNull(user);
	}
	
	
	
	
}
