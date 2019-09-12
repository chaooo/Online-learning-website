package top.chao.service.impl;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

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
	@Autowired
	private RestTemplate restTemplate;
	
	
	/**
	 * 查询所有方向及其下的科目
	 * @return
	 */
	@Override
	public ResultJson loadAll() {
		ResultJson result = new ResultJson();
		List<Direction> list = directionDao.selectAll();
		for (Direction direction : list) {
			//通过调用/course/direction服务加载相关的推荐课程信息
			String url = "http://localhost:7001/course/direction?direction_id="+direction.getId()+"&size=2";
			try {
				ResultJson courseResult = restTemplate.getForObject(url, ResultJson.class);
				if(courseResult.getCode()==ResultEnum.QUERY_SUCCESS.getCode()) {
					Map<?, ?> datas = (Map<?, ?>) courseResult.getData();
					List<?> courses = (List<?>) datas.get("list");
					direction.setCourses(courses);
				}
			} catch (RestClientException e) {
				e.printStackTrace();
			}
		}
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
