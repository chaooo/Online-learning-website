package top.chao.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.chao.common.ResultEnum;
import top.chao.common.ResultJson;
import top.chao.dao.DirectionMapper;
import top.chao.entity.Direction;
import top.chao.service.DirectionService;


@Service
public class DirectionServiceImpl implements DirectionService {
	/**
	 * 注入DAO
	 */
	@Autowired
	private DirectionMapper directionDao;
	/**
	 * 查询所有方向及其下的科目
	 * @return
	 */
	@Override
	public ResultJson loadAll() {
		ResultJson result = new ResultJson();
		List<Direction> list = directionDao.selectAll();
		if(list.isEmpty()) {
			result.setCode(ResultEnum.QUERY_EMPTY.getCode());
			result.setMsg(ResultEnum.QUERY_EMPTY.getMsg());
			return result;
		}
		result.setCode(ResultEnum.QUERY_SUCCESS.getCode());
		result.setMsg(ResultEnum.QUERY_SUCCESS.getMsg());
		result.setData(list);
		return result;
	}



}
