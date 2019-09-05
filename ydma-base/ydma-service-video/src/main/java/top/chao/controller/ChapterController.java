package top.chao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.chao.common.ResultJson;
import top.chao.service.ChapterService;

@RestController
public class ChapterController {
	
	@Autowired
	private ChapterService chapterService;
	
	@GetMapping("chapter/videos")
	public ResultJson loadChapterAndVideo(@RequestParam("id") int course_id) {
		return chapterService.loadChapterAndVideo(course_id);
	}

}
