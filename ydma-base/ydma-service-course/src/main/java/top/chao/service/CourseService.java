package top.chao.service;

import top.chao.common.ResultJson;

public interface CourseService {

	/**
	 * 根据课程Id查询单个课程
	 * @param id
	 * @return
	 */
	public ResultJson loadCourse(int id);
	
    /**
     * 根据科目ID查询课程列表（course表  ）
     * @param page
     * @param size
     * @param subject_id
     * @return
     */
	public ResultJson loadCourseBySubjectId(int page, int size, String type, int subject_id);
	
    /**
     * 根据方向ID查询课程列表（course表  ）
     * @param page
     * @param size
     * @param direction_id
     * @return
     */
	public ResultJson loadCourseByDirectionId(int page, int size, String type, int direction_id);
	
	/**
	 * 免费好课推荐查询
	 * @param page
	 * @param size
	 * @return
	 */
	public ResultJson loadCourseByPriceFree(int page, int size);

	/**
	 * 课程推荐查询
	 * @param page
	 * @param size
	 * @return
	 */
	public ResultJson loadCourseByRecommend(int page, int size);

	/**
	 * 课程模糊查询
	 * @param page
	 * @param size
	 * @param keyword
	 * @return
	 */
	public ResultJson loadCourseByKeyword(int page, int size, String keyword);

	/**
	 * 课程收藏
	 * @param collectCourse
	 * @return
	 */
	public ResultJson addCollectCourse(int id);

	/**
	 * 最新课程
	 * @param page
	 * @param size
	 * @return
	 */
	public ResultJson loadCourseByLatest(int page, int size);
	
	/**
	 * 加载 课程收藏夹
	 * @param token
	 * @return
	 */
	public ResultJson loadCollectCourse(String token);

	/**
	 * 最近学习记录
	 * @param token
	 * @return
	 */
	public ResultJson loadCourseHistory(String token);

	/**
	 * 根据学科并且评分排序 
	 * @param page
	 * @param size
	 * @param subject_id
	 * @return
	 */
	public ResultJson loadCourseBySubjectIdAndScore(int page, int size, int subject_id);


}
