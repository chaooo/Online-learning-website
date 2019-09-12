package top.chao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.chao.common.ResultJson;
import top.chao.service.VideoService;


@RestController
public class VideoController {
	@Autowired
	private VideoService videoService;

	/**
	 * 根据视频ID 查看 视频及关联评论，笔记，问答
	 * @param id
	 * @return
	 */
	@GetMapping("/video/get")
	public ResultJson loadCourse(@RequestParam("id")int id) {
		return videoService.loadVideoInfo(id);
	}
	
	
	
	
	
	
}
