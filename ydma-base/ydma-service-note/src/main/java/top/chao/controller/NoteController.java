package top.chao.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.chao.common.ResultJson;
import top.chao.entity.CollectNote;
import top.chao.entity.Note;
import top.chao.service.NoteService;

@RestController
public class NoteController {

	@Autowired
	private NoteService noteService;
	
	//添加笔记
	@PostMapping("/note/add")
	public ResultJson addNote(Note record) {
		return noteService.addNote(record);
	}
	
	//根据视频id查看笔记
	@GetMapping("/note/video")
	public ResultJson loadNoteByVideoId(@RequestParam(name="page",required=false,defaultValue="1")int page,
			@RequestParam(name="size",required=false,defaultValue="10")int size,
			@RequestParam("video_id")int video_id) {
		return noteService.loadNoteByVideoId(page, size, video_id);
	}
	
	//根据课程id查看笔记
	@GetMapping("/note/course")
	public ResultJson loadNoteByCourseId(@RequestParam(name="page",required=false,defaultValue="1")int page,
			@RequestParam(name="size",required=false,defaultValue="10")int size,
			@RequestParam("course_id")int course_id) {
		return noteService.loadNoteByCourseId(page, size, course_id);
	}
	
	//修改笔记
	@PostMapping("/note/modify")
	public ResultJson modifyNoteById(Note record) {
		return noteService.modifyNoteById(record);
	}
	
	//根据id删除笔记
	@PostMapping("/note/delete")
	public ResultJson deleteNoteById(@RequestParam("id") int id) {
		return noteService.deleteNoteById(id);
	}
	
	//收藏笔记
	@PostMapping("/note/collect")
	public ResultJson collectNote(CollectNote record) {
		return noteService.collectNote(record);
	}
	
	//取消收藏笔记
	@PostMapping("/note/cancelCollect")
	public ResultJson cancelCollectNote(int user_id, int note_id) {
		return noteService.cancelCollecNote(user_id, note_id);
	}
	
	//笔记点赞
	@PostMapping("/note/noteLike")
	public ResultJson NoteLike(int user_id, int note_id) {
		return noteService.noteLike(user_id, note_id);
	}
	
	//取消笔记点赞
	@PostMapping("/note/cancelLike")
	public ResultJson cancelNoteLike(int user_id, int note_id) {
		return noteService.cancelNoteLike(user_id, note_id);
	}
	
	/**
	 * 加载 笔记收藏夹
	 * @param request
	 * @return
	 */
	@GetMapping("/note/collect/get")
	public ResultJson loadCollectNote(HttpServletRequest request) {
		String token = request.getHeader("token");
		return noteService.loadCollectNote(token);
	}
	
}
