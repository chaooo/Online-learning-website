package top.chao.common;

public enum ResultEnum {
	
	TOKEN_SUCCESS(0, "令牌正确"),
	TOKEN_ERROR(7, "令牌错误"),
	LOGIN_SUCCESS(0, "登录成功"),
	LOGIN_ERROR(6, "登录失败"),
	RGIST_NAME_ERROR(5, "用户名被占用"),
	DETELE_SUCCESS(0, "删除成功"),
	DELETE_ERROR(4, "删除失败"),
	UPDATE_SUCCESS(0, "更新成功"),
	UPDATE_ERROR(3, "更新失败"),
	INSERT_SUCCESS(0, "添加成功"),
	INSERT_ERROR(2, "添加失败"),
	QUERY_SUCCESS(0, "查询成功"),
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
