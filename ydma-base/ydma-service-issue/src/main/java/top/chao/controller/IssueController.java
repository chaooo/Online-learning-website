package top.chao.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import top.chao.common.ResultJson;
import top.chao.entity.Answer;
import top.chao.entity.Issue;
import top.chao.service.IssueService;

@RestController
public class IssueController {

	@Autowired
	private IssueService issueService;
	
	//用户提问
	@PostMapping("/issue/add")
	public ResultJson addIssue(Issue record) {
		return issueService.addIssue(record);
	}
	
	//查看视频相关提问
	@GetMapping("/issue/video")
	public ResultJson loadIssue(int video_id) {
		return issueService.loadIssue(video_id);
	}
	
	//回复提问
	@PostMapping("/issue/reply")
	public ResultJson replyIssue(Answer record, HttpServletRequest request) {
		String token = request.getHeader("token");
		return issueService.replyIssue(record, token);
	}
	
	@PostMapping("/issue/setAnswer")
	public ResultJson setRightAnswer(int issue_id, int answer_id, HttpServletRequest request) {
		String token = request.getHeader("token");
		return issueService.setRightAnswer(issue_id, answer_id, token);
	}
}
