package top.chao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.TestCase;
import top.chao.RunVideoBoot;
import top.chao.dao.ChapterMapper;
import top.chao.entity.Chapter;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=RunVideoBoot.class)
public class TestChapterVideoMapper {
	
	@Autowired
	private ChapterMapper chapterDao;
	
	@Test
	public void test1() {
		System.out.println("--------test1----------");
	}
	
	
	@Test
	public void test3() {
		Chapter chapter = chapterDao.selectByPrimaryKey(1);
		System.out.println(chapter.getName());
		TestCase.assertNotNull(chapter);
	}
	
	@Test
	public void test4() {
		List<Chapter> chapter = chapterDao.selectByCourseId(1);
		System.out.println(chapter.size());
		TestCase.assertNotNull(chapter);
	}
	
	
	
}
