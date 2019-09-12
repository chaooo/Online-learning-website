package top.chao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.chao.common.ResultEnum;
import top.chao.common.ResultJson;
import top.chao.dao.AnswerMapper;
import top.chao.dao.IssueMapper;
import top.chao.entity.Answer;
import top.chao.entity.Issue;
import top.chao.service.IssueService;
import top.chao.util.JwtUtil;

@Service
public class IssueServiceImpl implements IssueService {

	@Autowired
	private IssueMapper issueDao;
	@Autowired
	private AnswerMapper answerDao;
	@Autowired
	private IssueServiceImpl selfClass;
	
	/**
	 * 用户提问
	 * @param record
	 * @return
	 */
	@Override
	public ResultJson addIssue(Issue record) {
		ResultJson result = new ResultJson();
		int row = issueDao.insertSelective(record);
		if(row > 0) {
			result.setCode(ResultEnum.ISSUE_SUCCESS.getCode());
			result.setMsg(ResultEnum.ISSUE_SUCCESS.getMsg());
		} else {
			result.setCode(ResultEnum.ISSUE_ERROR.getCode());
			result.setMsg(ResultEnum.ISSUE_ERROR.getMsg());
		}
		return result;
	}

	/**
	 * 查看所有提问
	 */
	@Override
	public ResultJson loadIssue(int video_id) {
		ResultJson result = new ResultJson();
		List<Issue> list = issueDao.selectAll(video_id);
		if(list.isEmpty()) {
			result.setCode(ResultEnum.QUERY_EMPTY.getCode());
			result.setMsg(ResultEnum.QUERY_EMPTY.getMsg());
		} else {
			result.setCode(ResultEnum.QUERY_SUCCESS.getCode());
			result.setMsg(ResultEnum.QUERY_SUCCESS.getMsg());
			result.setData(list);
		}
		return result;
	}

	//回复提问事务方法
	@Transactional
	public void reply(Answer record){
		int af = 0;
		int isf = 0;
		System.out.println("问题id："+record.getIssue_id());
		af = answerDao.insert(record);
		isf = issueDao.updateByIssue_id(record.getIssue_id());
		if(af == 0 || isf == 0) {
			throw new RuntimeException(ResultEnum.REPLY_ERROR.getMsg());
		}
	}
	/**
	 * 回复提问
	 */
	@Override
	public ResultJson replyIssue(Answer record, String token) {
		ResultJson result = new ResultJson();
		//解析token获取用户id
		//int user_id = JwtUtil.parseTokenUid(token);
//		String tokenStr = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJjaGFvMiIsInVpZCI6MzksImV4cCI6MTU2ODE4NzA3Mn0.J6xg9ij0iPh9Tq-8FbrQpOxHSmERcd8StaRGvkOaIYg";
//		int user_id = JwtUtil.parseTokenUid(tokenStr);
		record.setUser_id(1);
		record.setPublish_time(new Date());
		try {
			selfClass.reply(record);
			result.setCode(ResultEnum.REPLY_SUCCESS.getCode());
			result.setMsg(ResultEnum.REPLY_SUCCESS.getMsg());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.setCode(ResultEnum.REPLY_ERROR.getCode());
		result.setMsg(ResultEnum.REPLY_ERROR.getMsg());
		return result;
	}

	/**
	 * 设置正确答案
	 */
	@Override
	public ResultJson setRightAnswer(int issue_id,int answer_id, String token) {
		ResultJson result = new ResultJson();
		Issue record = new Issue();
		int user_id = JwtUtil.parseTokenUid(token);
		//int user_id = 3;测试数据
		int uid = issueDao.selectUserIdByPrimaryKey(issue_id);
		if(user_id != uid) {
			result.setCode(ResultEnum.SETANSWER_NOPERMISSING.getCode());
			result.setMsg(ResultEnum.SETANSWER_NOPERMISSING.getMsg());
			return result;
		} else {
			record.setId(issue_id);
			record.setRight_answer_id(answer_id);
			int row = issueDao.updateByPrimaryKeySelective(record);
			if(row > 0) {
				result.setCode(ResultEnum.SETANSWER_SUCCESS.getCode());
				result.setMsg(ResultEnum.SETANSWER_SUCCESS.getMsg());
			} else {
				result.setCode(ResultEnum.SETANSWER_ERROR.getCode());
				result.setMsg(ResultEnum.SETANSWER_ERROR.getMsg());
			}
		}
		return result;
	}

}
