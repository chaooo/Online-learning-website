package top.chao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.chao.common.ResultJson;
import top.chao.service.EvaluateService;

@RestController
public class EvaluateController{
	@Autowired
	private EvaluateService evaluateService;
	
	
    /**
     * 根据 视频ID 查询评价列表
     * @param page
     * @param size
     * @param subject_id
     * @return
     */
	@GetMapping("/evaluate/video")
	public ResultJson loadEvaluateByVideoId(
			@RequestParam(name="page",required=false,defaultValue="1")int page,
			@RequestParam(name="size",required=false,defaultValue="4")int size,
			@RequestParam("video_id") int video_id) {
		return evaluateService.loadEvaluateByVideoId(page, size, video_id);
	}
	
    /**
     * 根据课程ID查询评价列表
     * @param page
     * @param size
     * @param direction_id
     * @return
     */
	@GetMapping("/evaluate/course")
	public ResultJson loadEvaluateByCourseId(
			@RequestParam(name="page",required=false,defaultValue="1")int page,
			@RequestParam(name="size",required=false,defaultValue="4")int size,
			@RequestParam("course_id") int course_id) {
		return evaluateService.loadEvaluateByCourseId(page, size, course_id);
	}
	
	/**
	 * 评价点赞
	 * @param page
	 * @param size
	 * @return
	 */
	@PostMapping("/course/like")
	public ResultJson updateEvaluateAddLike(@RequestParam("id") int id) {
		return evaluateService.updateEvaluateAddLike(id);
	}
	
	
	
	
	
	
}
