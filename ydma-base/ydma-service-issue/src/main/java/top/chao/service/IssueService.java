package top.chao.service;

import top.chao.common.ResultJson;
import top.chao.entity.Answer;
import top.chao.entity.Issue;

public interface IssueService {

	/**
	 * 用户提问
	 * @param record
	 * @return
	 */
	public ResultJson addIssue(Issue record);
	
	/**
	 * 查看所有提问
	 * @return
	 */
	public ResultJson loadIssue(int video_id);
	
	/**
	 * 回复提问
	 * @param record
	 * @param token
	 * @return
	 */
	public ResultJson replyIssue(Answer record,String token);
	
	/**
	 * 设置正确答案
	 * @param answer_id
	 * @param token
	 * @return
	 */
	public ResultJson setRightAnswer(int issue_id,int answer_id,String token);
}
