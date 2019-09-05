package top.chao.service;

import top.chao.common.ResultJson;

public interface ChapterService {
	
	/**
	 *  通过课程Id 加载章节和视频
	 * @return
	 */
	public ResultJson loadChapterAndVideo(int course_id);
	
}
