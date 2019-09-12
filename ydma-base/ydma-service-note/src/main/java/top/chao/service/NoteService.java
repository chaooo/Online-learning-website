package top.chao.service;

import top.chao.common.ResultJson;
import top.chao.entity.Note;
import top.chao.entity.CollectNote;

public interface NoteService {

	/**
	 * 添加笔记
	 * @param record 添加的笔记对象信息
	 * @return 处理结果
	 */
	public ResultJson addNote(Note record);
	
	/**
	 * 根据视频ID查询笔记
	 * @param
	 * @return
	 */
	public ResultJson loadNoteByVideoId(int page, int size, int video_id);
	
	/**
	 * 根据课程ID查询笔记
	 * @param 
	 * @return
	 */
	public ResultJson loadNoteByCourseId(int page, int size, int course_id);
	
	/**
	 * 修改笔记
	 * @param
	 * @return
	 */
	public ResultJson modifyNoteById(Note record);
	
	/**
	 * 根据id删除笔记
	 * @param id
	 * @return
	 */
	public ResultJson deleteNoteById(int id);
	
	/**
	 * 笔记收藏
	 * @param record
	 * @return
	 */
	public ResultJson collectNote(CollectNote record);
	
	/**
	 * 取消笔记收藏
	 * @param record
	 * @return
	 */
	public ResultJson cancelCollecNote(int user_id, int note_id);
	
	/**
	 * 笔记点赞
	 * @param user_id
	 * @param note_id
	 * @return
	 */
	public ResultJson noteLike(int user_id, int note_id);
	
	/**
	 * 取消笔记点赞
	 * @param user_id
	 * @param note_id
	 * @return
	 */
	public ResultJson cancelNoteLike(int user_id, int note_id) ;
	
	/**
	 * 加载 笔记收藏夹
	 * @param request
	 * @return
	 */
	public ResultJson loadCollectNote(String token);
}
