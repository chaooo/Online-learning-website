package top.chao.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.chao.common.ResultJson;
import top.chao.service.CourseService;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
public class CourseController{
	@Autowired
	private CourseService courseService;
	
	/**
	 * 查看 课程信息
	 * @param id
	 * @return
	 */
	@GetMapping("/course/get")
	public ResultJson loadCourse(@RequestParam("id")int id) {
		return courseService.loadCourse(id);
	}
	
	/**
	 * 根据学科 查询分页课程列表
	 * @param page
	 * @param size
	 * @param subject_id
	 * @return
	 */
	@GetMapping("/course/subject")
	public ResultJson loadCourseBySubjectId(
		@RequestParam(name="page",required=false,defaultValue="1")int page,
		@RequestParam(name="size",required=false,defaultValue="4")int size,
		@RequestParam("subject_id")int subject_id) {
		return courseService.loadCourseBySubjectId(page, size, subject_id);
	}
	
	/**
	 * 根据方向 查询分页课程列表
	 * @param page
	 * @param size
	 * @param direction_id
	 * @return
	 */
	@GetMapping("/course/direction")
	public ResultJson loadCourseByDirectionId(
		@RequestParam(name="page",required=false,defaultValue="1")int page,
		@RequestParam(name="size",required=false,defaultValue="4")int size,
		@RequestParam("direction_id")int direction_id) {
		return courseService.loadCourseByDirectionId(page, size, direction_id);
	}
	/**
	 * 课程推荐查询
	 * @param page
	 * @param size
	 * @return
	 */
	@GetMapping("/course/recommend")
	public ResultJson loadCourseByRecommend(
		@RequestParam(name="page",required=false,defaultValue="1")int page,
		@RequestParam(name="size",required=false,defaultValue="5")int size) {
		return courseService.loadCourseByRecommend(page, size);
	}
	
	/**
	 * 免费好课查询
	 * @param page
	 * @param size
	 * @return
	 */
	@GetMapping("/course/free")
	public ResultJson loadCourseByPriceFree(
		@RequestParam(name="page",required=false,defaultValue="1")int page,
		@RequestParam(name="size",required=false,defaultValue="5")int size) {
		return courseService.loadCourseByPriceFree(page, size);
	}
	
	/**
	 * 根据学科并且评分排序 
	 * @param page
	 * @param size
	 * @param subject_id
	 * @return
	 */
	@GetMapping("/course/score")
	public ResultJson loadCourseBySubjectIdAndScore(
		@RequestParam(name="page",required=false,defaultValue="1")int page,
		@RequestParam(name="size",required=false,defaultValue="6")int size,
		@RequestParam("subject_id")int subject_id) {
		return courseService.loadCourseBySubjectIdAndScore(page, size, subject_id);
	}
	/**
	 * 最新课程
	 * @param page
	 * @param size
	 * @return
	 */
	@GetMapping("/course/latest")
	public ResultJson loadCourseByLatest(
		@RequestParam(name="page",required=false,defaultValue="1")int page,
		@RequestParam(name="size",required=false,defaultValue="5")int size) {
		return courseService.loadCourseByLatest(page, size);
	}
	/**
	 * 课程模糊查询
	 * @param page
	 * @param size
	 * @param keyword
	 * @return
	 */
	@GetMapping("/course/serach")
	public ResultJson loadCourseByKeyword(
		@RequestParam(name="page",required=false,defaultValue="1")int page,
		@RequestParam(name="size",required=false,defaultValue="5")int size,
		@RequestParam("keyword")String keyword) {
		return courseService.loadCourseByKeyword(page, size, keyword);
	}
	
	/**
	 * 课程收藏
	 * @param collectCourse
	 * @return
	 */
	@PostMapping("/course/collect")
	public ResultJson CollectCourse(@RequestParam("course_id") int course_id) {
		return courseService.addCollectCourse(course_id);
	}
	
	/**
	 * 加载 课程收藏夹
	 * @param request
	 * @return
	 */
	@GetMapping("/course/collect/get")
	public ResultJson loadCollectCourse(HttpServletRequest request) {
		String token = request.getHeader("token");
		return courseService.loadCollectCourse(token);
	}
	
	/**
	 * 最近学习记录
	 * @param request
	 * @return
	 */
	@GetMapping("/course/history")
	public ResultJson loadCourseHistory(HttpServletRequest request) {
		String token = request.getHeader("token");
		return courseService.loadCourseHistory(token);
	}
	
}
