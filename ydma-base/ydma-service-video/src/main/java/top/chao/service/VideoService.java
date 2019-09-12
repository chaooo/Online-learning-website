package top.chao.service;

import top.chao.common.ResultJson;

public interface VideoService {

	/**
	 * 根据视频ID 查看 视频信息
	 * @param id
	 * @return
	 */
	ResultJson loadVideoInfo(int id);

}
