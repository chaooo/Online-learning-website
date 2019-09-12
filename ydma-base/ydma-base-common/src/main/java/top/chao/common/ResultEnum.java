package top.chao.common;

public enum ResultEnum {
	
	SETANSWER_SUCCESS(0,"设置正确答案成功"),
	SETANSWER_ERROR(20,"设置正确答案失败"),
	SETANSWER_NOPERMISSING(19,"无权限设置"),
	REPLY_SUCCESS(0,"回复成功"),
	REPLY_ERROR(18,"回复失败"),
	OLD_PASSWORD_ERROR(17, "旧密码输入错误"),
	ISSUE_SUCCESS(0,"提问成功"),
	ISSUE_ERROR(16,"提问失败"),
	CANCELLIKE_SUCCESS(0,"取消点赞成功"),
	CANCELLIKE_ERROR(15,"取消点赞失败"),
	LIKE_SUCCESS(0,"点赞成功"),
	LIKE_ERROR(14,"点赞失败"),
	LIKEED_ERROR(13,"已点赞过"),
	MODIFY_SUCCESS(0,"修改成功"),
	MODIFY_ERROR(12,"修改失败"),
	COLLECT_SUCCESS(0,"收藏成功"),
	COLLECTED_ERROR(11,"已收藏过"),
	COLLECT_ERROR(9,"收藏失败"),
	CANCELCOLLECT_SUCCESS(0,"取消收藏成功"),
	CANCELCOLLECT_ERROR(8,"取消收藏失败"),
	TOKEN_SUCCESS(0, "令牌正确"),
	TOKEN_ERROR(7, "令牌错误"),
	LOGIN_SUCCESS(0, "登录成功"),
	LOGIN_ERROR(6, "登录失败"),
	RGIST_NAME_ERROR(5, "用户名被占用"),
	DELETE_SUCCESS(0, "删除成功"),
	DELETE_ERROR(4, "删除失败"),
	UPDATE_SUCCESS(0, "更新成功"),
	UPDATE_ERROR(3, "更新失败"),
	INSERT_SUCCESS(0, "添加成功"),
	INSERT_ERROR(2, "添加失败"),
	QUERY_SUCCESS(0, "查询成功"),
	QUERY_EMPTY(10, "未找到记录"),
	QUERY_ERROR(1, "查询失败"),
	SUCCESS(0, "成功"),
	FAIL(-1, "失败");

	private int code;
	private String msg;

	private ResultEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
}
