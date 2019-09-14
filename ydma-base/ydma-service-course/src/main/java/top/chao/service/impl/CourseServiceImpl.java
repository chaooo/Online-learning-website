package top.chao.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import top.chao.common.ResultEnum;
import top.chao.common.ResultJson;
import top.chao.dao.BrowsingHistoryMapper;
import top.chao.dao.CollectCourseMapper;
import top.chao.dao.CourseMapper;
import top.chao.entity.BrowsingHistory;
import top.chao.entity.CollectCourse;
import top.chao.entity.Course;
import top.chao.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseMapper courseDao;
	@Autowired
	private CollectCourseMapper collectDao;
	@Autowired
	private BrowsingHistoryMapper browsingHistoryDao;
	/**
	 * 查询列表分页公共方法
	 * @param p
	 * @param list
	 * @return
	 */
	private ResultJson queryListReturn(Page<Object> p, List<Course> list) {
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
	 * 根据课程Id查询单个课程
	 * @param id
	 * @return
	 */
	@Override
	@Cacheable(value="course",key="#root.methodName+'['+#id+']'")
	public ResultJson loadCourse(int id) {
		ResultJson result = new ResultJson();
		Course course = courseDao.selectByPrimaryKey(id);
		if(course!=null) {
			result.setCode(ResultEnum.QUERY_SUCCESS.getCode());
			result.setMsg(ResultEnum.QUERY_SUCCESS.getMsg());
			result.setData(course);
		} else {
			result.setCode(ResultEnum.QUERY_ERROR.getCode());
			result.setMsg(ResultEnum.QUERY_ERROR.getMsg());	
		}
		return result;
	}
	
    /**
     * 根据科目ID查询课程列表（course表  ）
     * @param page
     * @param size
     * @param subject_id
     * @return
     */
	@Override
	@Cacheable(value="course",key="#root.methodName+'['+#page+','+#size+','+#type+','+#subject_id+']'")
	public ResultJson loadCourseBySubjectId(int page, int size, String type, int subject_id) {
		Page<Object> p = PageHelper.startPage(page, size);
		List<Course> list = courseDao.selectBySubjectId(type, subject_id);
		return queryListReturn(p, list);
	}
	
    /**
     * 根据方向ID查询课程列表（course表  ）
     * @param page
     * @param size
     * @param direction_id
     * @return
     */
	@Override
	@Cacheable(value="course",key="#root.methodName+'['+#page+','+#size+','+#type+','+#direction_id+']'")
	public ResultJson loadCourseByDirectionId(int page, int size, String type, int direction_id) {
		Page<Object> p = PageHelper.startPage(page, size);
		List<Course> list = courseDao.selectByDirectionId(type,direction_id);
		return queryListReturn(p, list);
	}
	
	/**
	 * 免费好课查询
	 * @param page
	 * @param size
	 * @return
	 */
	@Override
	public ResultJson loadCourseByPriceFree(int page, int size) {
		Page<Object> p = PageHelper.startPage(page, size);
		List<Course> list = courseDao.selectByPriceFree();
		return queryListReturn(p, list);
	}

	/**
	 * 课程推荐查询
	 * @param page
	 * @param size
	 * @return
	 */
	@Override
	public ResultJson loadCourseByRecommend(int page, int size) {
		Page<Object> p = PageHelper.startPage(page, size);
		List<Course> list = courseDao.selectByRecommend();
		return queryListReturn(p, list);
	}

	/**
	 * 课程模糊查询
	 * @param page
	 * @param size
	 * @param keyword
	 * @return
	 */
	@Override
	public ResultJson loadCourseByKeyword(int page, int size, String keyword) {
		Page<Object> p = PageHelper.startPage(page, size);
//		StringBuilder key = new StringBuilder("%");
//		key.append(keyword);
//		key.append("%");
//		List<Course> list = courseDao.selectByKeyword(key.toString());
		List<Course> list = courseDao.selectByKeyword(keyword);
		return queryListReturn(p, list);
	}

	/**
	 * 课程收藏
	 * @param collectCourse
	 * @return
	 */
	@Override
	public ResultJson addCollectCourse(int course_id) {
		ResultJson result = new ResultJson();
		CollectCourse collectCourse = collectDao.selectByUserIdAndCourseId(1, course_id);
		if(collectCourse!=null) {
			result.setCode(ResultEnum.COLLECTED_ERROR.getCode());
			result.setMsg(ResultEnum.COLLECTED_ERROR.getMsg());
			return result;
		}
		collectCourse = new CollectCourse();
		collectCourse.setUser_id(1);
		collectCourse.setCourse_id(course_id);
		collectCourse.setCollect_time(new Date());
		int rows = collectDao.insert(collectCourse);
		if(rows>0) {
			result.setCode(ResultEnum.COLLECT_SUCCESS.getCode());
			result.setMsg(ResultEnum.COLLECT_SUCCESS.getMsg());
		} else {
			result.setCode(ResultEnum.COLLECT_ERROR.getCode());
			result.setMsg(ResultEnum.COLLECT_ERROR.getMsg());	
		}
		return result;
	}

	/**
	 * 最新课程
	 * @param page
	 * @param size
	 * @return
	 */
	@Override
	public ResultJson loadCourseByLatest(int page, int size) {
		Page<Object> p = PageHelper.startPage(page, size);
		List<Course> list = courseDao.selectByLatest();
		return queryListReturn(p, list);
	}

	/**
	 * 加载 课程收藏夹
	 * @param token
	 * @return
	 */
	@Override
	public ResultJson loadCollectCourse(String token) {
		int user_id = 1;//根据token得到user_id
		List<CollectCourse> list = collectDao.selectByUserId(user_id);
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

	/**
	 * 最近学习记录
	 * @param token
	 * @return
	 */
	@Override
	public ResultJson loadCourseHistory(String token) {
		int user_id = 1;//根据token得到user_id
		List<BrowsingHistory> list = browsingHistoryDao.selectByUserId(user_id);
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

	/**
	 * 根据学科并且评分排序 
	 * @param page
	 * @param size
	 * @param subject_id
	 * @return
	 */
	@Override
	public ResultJson loadCourseBySubjectIdAndScore(int page, int size, int subject_id) {
		Page<Object> p = PageHelper.startPage(page, size);
		List<Course> list = courseDao.selectBySubjectIdAndScore(subject_id);
		return queryListReturn(p, list);
	}

}
