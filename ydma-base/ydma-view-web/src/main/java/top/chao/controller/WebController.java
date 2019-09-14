package top.chao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
	// 主页
	@RequestMapping({"/index", "/", ""})
	public ModelAndView toIndex() {
		ModelAndView mav = new ModelAndView("index");//templates/index.html
		return mav;
	}
	// 登录,注册
	@RequestMapping("user/login")
	public ModelAndView toLogin() {
		ModelAndView mav = new ModelAndView("login");//templates/login.html
		return mav;
	}
	//课程列表
	@RequestMapping("/course/list")
	public ModelAndView CourseList() {
		ModelAndView mav = new ModelAndView("course_list");//templates/course_list.html
		return mav;
	}
	// 课程详情
	@RequestMapping("/course/detail")
	public ModelAndView Course() {
		ModelAndView mav = new ModelAndView("course_detail");//templates/course_detail.html
		return mav;
	}
	// 视频播放
	@RequestMapping("/video")
	public ModelAndView Video() {
		ModelAndView mav = new ModelAndView("video");//templates/course_detail.html
		return mav;
	}
	
	
	
}
