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
import top.chao.dao.EvaluateMapper;
import top.chao.dao.EvaluationLikeMapper;
import top.chao.entity.Evaluate;
import top.chao.entity.EvaluationLike;
import top.chao.service.EvaluateService;

@Service
public class EvaluateServiceImpl implements EvaluateService{
	
	@Autowired
	private EvaluateMapper evaluateDao;
	@Autowired
	private EvaluationLikeMapper likeDao;
	@Autowired
	private EvaluateServiceImpl selfClass;
	
	/**
	 * 查询列表分页公共方法
	 * @param p
	 * @param list
	 * @return
	 */
	private ResultJson queryListReturn(Page<Object> p, List<Evaluate> list) {
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
     * 根据 视频ID 查询评价列表
     * @param page
     * @param size
     * @param subject_id
     * @return
     */
	@Override
	public ResultJson loadEvaluateByVideoId(int page, int size, int video_id) {
		Page<Object> p = PageHelper.startPage(page, size);
		List<Evaluate> list = evaluateDao.selectByVideoId(video_id);
		return queryListReturn(p, list);
	}
	
    /**
     * 根据课程ID查询评价列表
     * @param page
     * @param size
     * @param direction_id
     * @return
     */
	@Override
	public ResultJson loadEvaluateByCourseId(int page, int size, int course_id) {
		Page<Object> p = PageHelper.startPage(page, size);
		List<Evaluate> list = evaluateDao.selectByCourseId(course_id);
		return queryListReturn(p, list);
	}

	/**
	 * 评价点赞
	 * @param page
	 * @param size
	 * @return
	 */
	@Override
	public ResultJson updateEvaluateAddLike(int id) {
		ResultJson result = new ResultJson();
		EvaluationLike evaluationLike = likeDao.selectByEvaluationId(id);
		if(evaluationLike!=null) {//已点过赞
			result.setCode(ResultEnum.LIKEED_ERROR.getCode());
			result.setMsg(ResultEnum.LIKEED_ERROR.getMsg());
			return result;
		}
		try {
			selfClass.updateEvaluateInsertLike(id);
			result.setCode(ResultEnum.LIKE_SUCCESS.getCode());
			result.setMsg(ResultEnum.LIKE_SUCCESS.getMsg());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.setCode(ResultEnum.LIKE_ERROR.getCode());
		result.setMsg(ResultEnum.LIKE_ERROR.getMsg());
		return result;
	}
	
	@Transactional
	public void updateEvaluateInsertLike(int id) {
		int rows1 = evaluateDao.addLikeCountById(id);
		EvaluationLike evaluationLike = new EvaluationLike();
		evaluationLike.setEvaluation_id(id);
		evaluationLike.setUser_id(1);
		evaluationLike.setLike_time(new Date());
		int rows2 = likeDao.insert(evaluationLike);
		if(rows1==0 || rows2==0) {
			throw new RuntimeException(ResultEnum.LIKE_ERROR.getMsg());
		}
	}


	

}
