package top.chao.service;

import top.chao.common.ResultJson;


public interface DirectionService {
	/**
	 * 查询所有方向及其下的科目
	 * @return
	 */
	public ResultJson loadAll();

	
}
