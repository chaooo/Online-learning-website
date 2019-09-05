package top.chao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.TestCase;
import top.chao.RunDirectionBoot;
import top.chao.dao.DirectionMapper;
import top.chao.entity.Direction;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=RunDirectionBoot.class)
public class TestDirectionMapper {
	
	@Autowired
	private DirectionMapper dao;
	
	@Test
	public void test1() {
		System.out.println("--------test1----------");
	}
	
	@Test
	public void test2() {
		List<Direction> list = dao.selectAll();
		System.out.println(list);
		TestCase.assertNotNull(list);
	}
	

	
	
	
	
}
