package top.chao.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import top.chao.common.ResultEnum;
import top.chao.common.ResultJson;
import top.chao.dao.CollectNoteMapper;
import top.chao.dao.NoteLikeMapper;
import top.chao.dao.NoteMapper;
import top.chao.entity.Note;
import top.chao.service.NoteService;
import top.chao.entity.CollectNote;
import top.chao.entity.NoteLike ;

@Service
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	private NoteMapper noteDao;
	@Autowired
	private CollectNoteMapper collectNoteDao;
	@Autowired
	private NoteLikeMapper noteLikeDao; 
	@Autowired
	private NoteServiceImpl selfClass; 

	/**
	 * 查询列表分页公共方法
	 * @param p
	 * @param list
	 * @return
	 */
	private ResultJson queryListReturn(Page<Object> p, List<Note> list) {
		ResultJson result = new ResultJson();
		if(list.isEmpty()) {
			result.setCode(ResultEnum.QUERY_ERROR.getCode());
			result.setMsg(ResultEnum.QUERY_ERROR.getMsg());	
			return result;
		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("list", list);
		data.put("maxPage", p.getPages());
		data.put("CurrentPage", p.getPageNum());
		data.put("total", p.getTotal());
		
		result.setData(data);
		result.setCode(ResultEnum.QUERY_SUCCESS.getCode());
		result.setMsg(ResultEnum.QUERY_SUCCESS.getMsg());
		return result;
	}
	
	/**
	 * 添加笔记
	 * @param record 添加的笔记对象信息
	 * @return 处理结果
	 */
	@Override
	public ResultJson addNote(Note record) {
		ResultJson result = new ResultJson();
		record.setPublish_time(new Date());
		int row = noteDao.insert(record);
		if(row > 0) {
			result.setCode(ResultEnum.INSERT_SUCCESS.getCode());
			result.setMsg(ResultEnum.INSERT_SUCCESS.getMsg());
			return result;
		}
		result.setCode(ResultEnum.INSERT_ERROR.getCode());
		result.setMsg(ResultEnum.INSERT_ERROR.getMsg());
		return result;
	}

	/**
	 * 根据视频ID查询笔记
	 * @param video_id
	 * @return
	 */
	@Override
	public ResultJson loadNoteByVideoId(int page, int size, int video_id) {
		Page<Object> p = PageHelper.startPage(page, size);
		List<Note> list = noteDao.selectByVideoId(video_id);
		return queryListReturn(p,list);
	}

	/**
	 * 根据课程ID查询笔记
	 * @param video_id
	 * @return
	 */
	@Override
	public ResultJson loadNoteByCourseId(int page, int size, int course_id) {
		Page<Object> p = PageHelper.startPage(page, size);
		List<Note> list = noteDao.selectByCourseId(course_id);
		return queryListReturn(p,list);
	}

	/**
	 * 修改笔记
	 * @param 
	 * @return
	 */
	@Override
	public ResultJson modifyNoteById(Note record) {
		ResultJson result = new ResultJson();
		int row = noteDao.updateByPrimaryKeySelective(record);
		if(row > 0) {
			result.setCode(ResultEnum.MODIFY_SUCCESS.getCode());
			result.setMsg(ResultEnum.MODIFY_SUCCESS.getMsg());
			return result;
		}
		result.setCode(ResultEnum.MODIFY_ERROR.getCode());
		result.setMsg(ResultEnum.MODIFY_ERROR.getMsg());
		return result;
	}
	
	/**
	 * 删除笔记
	 */
	@Override
	public ResultJson deleteNoteById(int id) {
		ResultJson result = new ResultJson();
		int row = noteDao.deleteByPrimaryKey(id);
		if(row > 0) {
			result.setCode(ResultEnum.DELETE_SUCCESS.getCode());
			result.setMsg(ResultEnum.DELETE_SUCCESS.getMsg());
			return result;
		}
		result.setCode(ResultEnum.DELETE_ERROR.getCode());
		result.setMsg(ResultEnum.DELETE_ERROR.getMsg());
		return result;
	}

	/**
	 * 笔记收藏
	 */
	@Override
	public ResultJson collectNote(CollectNote record) {
		ResultJson result = new ResultJson();
		CollectNote collectNote = collectNoteDao.selectByUserIdAndNoteId(record.getUser_id(), record.getNote_id());
		if(collectNote != null) {
			result.setCode(ResultEnum.COLLECTED_ERROR.getCode());
			result.setMsg(ResultEnum.COLLECTED_ERROR.getMsg());
			return result;
		}
		record.setCollect_time(new Date());
		int row = collectNoteDao.insert(record);
		if(row > 0) {
			result.setCode(ResultEnum.COLLECT_SUCCESS.getCode());
			result.setMsg(ResultEnum.COLLECT_SUCCESS.getMsg());
		} else {
			result.setCode(ResultEnum.COLLECT_ERROR.getCode());
			result.setMsg(ResultEnum.COLLECT_ERROR.getMsg());
		}
		return result;
	}

	/**
	 * 取消笔记收藏
	 */
	@Override
	public ResultJson cancelCollecNote(int user_id, int note_id) {
		ResultJson result = new ResultJson();
		int row = collectNoteDao.deleteByUserIdAndNoteId(user_id, note_id);
		if(row > 0) {
			result.setCode(ResultEnum.CANCELCOLLECT_SUCCESS.getCode());
			result.setMsg(ResultEnum.CANCELCOLLECT_SUCCESS.getMsg());
		} else {
			result.setCode(ResultEnum.CANCELCOLLECT_ERROR.getCode());
			result.setMsg(ResultEnum.CANCELCOLLECT_ERROR.getMsg());
		}
		return result;
	}

	@Transactional
	public void addNoteLike(int user_id, int note_id) {
		int nlf = 0;
		int nf = 0;
		NoteLike record = new NoteLike();
		record.setNote_id(note_id);
		record.setUser_id(user_id);
		record.setLike_time(new Date());
		nlf = noteLikeDao.insert(record);
		nf = noteDao.addLikeCountById(note_id);
		if(nlf == 0 || nf == 0) {
			throw new RuntimeException(ResultEnum.LIKE_ERROR.getMsg());
		} 
	}
	
	
	/**
	 * 笔记点赞
	 */
	@Override
	public ResultJson noteLike(int user_id, int note_id) {
		ResultJson result = new ResultJson();
		NoteLike noteLike = noteLikeDao.selectByUserIdAndNoteId(user_id, note_id);
		if(noteLike == null) {
			try {
				selfClass.addNoteLike(user_id,note_id);
				result.setCode(ResultEnum.LIKE_SUCCESS.getCode());
				result.setMsg(ResultEnum.LIKE_SUCCESS.getMsg());
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			}
			result.setCode(ResultEnum.LIKE_ERROR.getCode());
			result.setMsg(ResultEnum.LIKE_ERROR.getMsg());
		} else {
			result.setCode(ResultEnum.LIKEED_ERROR.getCode());
			result.setMsg(ResultEnum.LIKEED_ERROR.getMsg());
		}
		return result;
	}
	
	@Transactional
	public void cutNoteLike(int user_id, int note_id) {
		int nlf = 0;
		int nf = 0;
		nlf = noteLikeDao.deleteByUserIdAndNoteId(user_id, note_id);
		nf = noteDao.cutLikeCountById(note_id);
		if(nlf == 0 || nf == 0) {
			throw new RuntimeException(ResultEnum.LIKE_ERROR.getMsg());
		} 
	}
	
	/**
	 * 取消笔记点赞
	 */
	@Override
	public ResultJson cancelNoteLike(int user_id, int note_id) {
		ResultJson result = new ResultJson();
		try {
			selfClass.cutNoteLike(user_id,note_id);
			result.setCode(ResultEnum.CANCELLIKE_SUCCESS.getCode());
			result.setMsg(ResultEnum.CANCELLIKE_SUCCESS.getMsg());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.setCode(ResultEnum.CANCELLIKE_ERROR.getCode());
		result.setMsg(ResultEnum.CANCELLIKE_ERROR.getMsg());
		return result;
	}

	/**
	 * 加载 笔记收藏夹
	 * @param request
	 * @return
	 */
	@Override
	public ResultJson loadCollectNote(String token) {
		int user_id = 1;//根据token得到user_id
		List<CollectNote> list = collectNoteDao.selectByUserId(user_id);
		ResultJson result = new ResultJson();
		if(list.isEmpty()) {
			result.setCode(ResultEnum.QUERY_ERROR.getCode());
			result.setMsg(ResultEnum.QUERY_ERROR.getMsg());	
			return result;
		}
		result.setData(list);
		result.setCode(ResultEnum.QUERY_SUCCESS.getCode());
		result.setMsg(ResultEnum.QUERY_SUCCESS.getMsg());
		return result;
	}

}
