package top.chao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import top.chao.common.ResultEnum;
import top.chao.common.ResultJson;
import top.chao.dao.ChapterMapper;
import top.chao.entity.Chapter;
import top.chao.service.ChapterService;

public class ChapterServiceImpl implements ChapterService {
	
	@Autowired
	private ChapterMapper chapterDao;

	@Override
	public ResultJson loadChapterAndVideo(int course_id) {
		ResultJson result = new ResultJson();
		List<Chapter> list = chapterDao.selectByCourseId(course_id);
		if(list.isEmpty()) {
			result.setCode(ResultEnum.QUERY_EMPTY.getCode());
			result.setMsg(ResultEnum.QUERY_EMPTY.getMsg());
			return result;
		}
		result.setCode(ResultEnum.QUERY_SUCCESS.getCode());
		result.setMsg(ResultEnum.QUERY_SUCCESS.getMsg());
		return result;
	}

}
