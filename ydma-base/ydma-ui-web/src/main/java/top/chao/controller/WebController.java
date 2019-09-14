package top.chao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

	/**
	 * 主页
	 * @return
	 */
	@GetMapping("/index")
	public ModelAndView toIndex() {
		ModelAndView mav = new ModelAndView("index");//templates/index.html
		return mav;
	}
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	/**
	 * 注册
	 * @return
	 */
	@RequestMapping("/regist")
	public String regist() {
		return "regist";
	}
	
	/**
	 * 课程列表
	 * @return
	 */
	@GetMapping("/course/list")
	public ModelAndView CourseList() {
		ModelAndView mav = new ModelAndView("course_list");//templates/course_list.html
		return mav;
	}
	
	/**
	 * 课程详情
	 * @return
	 */
	@GetMapping("/course/detail")
	public ModelAndView Course() {
		ModelAndView mav = new ModelAndView("course");//templates/course_list.html
		return mav;
	}
	
	
	
	
	
}
