package top.chao.service;

import top.chao.common.ResultJson;

public interface EvaluateService {

    /**
     * 根据 视频ID 查询评价列表
     * @param page
     * @param size
     * @param subject_id
     * @return
     */
	public ResultJson loadEvaluateByVideoId(int page, int size, int video_id);
	
    /**
     * 根据课程ID查询评价列表
     * @param page
     * @param size
     * @param direction_id
     * @return
     */
	public ResultJson loadEvaluateByCourseId(int page, int size, int course_id);
	
	/**
	 * 评价点赞
	 * @param page
	 * @param size
	 * @return
	 */
	public ResultJson updateEvaluateAddLike(int id);


}
