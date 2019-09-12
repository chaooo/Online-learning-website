package top.chao.common;

import java.io.Serializable;

public class ResultJson implements Serializable{
	private int code;
	private String msg;
	private Object data;
	@Override
	public String toString() {
		return "JsonReult [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
	public ResultJson() {
		super();
	}
	public ResultJson(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
