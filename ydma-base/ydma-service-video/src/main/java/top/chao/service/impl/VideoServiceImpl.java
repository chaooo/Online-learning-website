package top.chao.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import top.chao.common.ResultEnum;
import top.chao.common.ResultJson;
import top.chao.dao.VideoMapper;
import top.chao.entity.Video;
import top.chao.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	private VideoMapper videoDao;
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * 根据视频ID 查看 视频信息
	 * @param id
	 * @return
	 */
	@Override
	public ResultJson loadVideoInfo(int id) {
		ResultJson result = new ResultJson();
		Video video = videoDao.selectByPrimaryKey(id);
		if(video!=null) {
			//通过调用/note/video服务加载相关的笔记信息
			String noteUri = "http://localhost:7005/note/video?video_id="+video.getId();
			try {
				ResultJson noteResult = restTemplate.getForObject(noteUri, ResultJson.class);
				if(noteResult.getCode()==ResultEnum.QUERY_SUCCESS.getCode()) {
					Map<?, ?> datas = (Map<?, ?>) noteResult.getData();
					List<?> notes = (List<?>) datas.get("list");
					video.setNotes(notes);
				}
			} catch (RestClientException e1) {
				e1.printStackTrace();
			}
			//通过调用/issue/video服务加载相关的问答信息
			String issueUri = "http://localhost:7004/issue/video?video_id="+video.getId();
			try {
				ResultJson issueResult = restTemplate.getForObject(issueUri, ResultJson.class);
				if(issueResult.getCode()==ResultEnum.QUERY_SUCCESS.getCode()) {
					Map<?, ?> datas = (Map<?, ?>) issueResult.getData();
					List<?> issues = (List<?>) datas.get("list");
					video.setIssues(issues);
				}
			} catch (RestClientException e) {
				e.printStackTrace();
			}
			//通过调用/evaluate/video服务加载相关的问答信息
			String evaluateUri = "http://localhost:7003/evaluate/video?video_id="+video.getId();
			try {
				ResultJson evaluateResult = restTemplate.getForObject(evaluateUri, ResultJson.class);
				if(evaluateResult.getCode()==ResultEnum.QUERY_SUCCESS.getCode()) {
					Map<?, ?> datas = (Map<?, ?>) evaluateResult.getData();
					List<?> evaluates = (List<?>) datas.get("list");
					video.setEvaluates(evaluates);
				}
			} catch (RestClientException e) {
				e.printStackTrace();
			}
			result.setCode(ResultEnum.QUERY_SUCCESS.getCode());
			result.setMsg(ResultEnum.QUERY_SUCCESS.getMsg());
			result.setData(video);
		} else {
			result.setCode(ResultEnum.QUERY_ERROR.getCode());
			result.setMsg(ResultEnum.QUERY_ERROR.getMsg());	
		}
		return result;
	}

}
