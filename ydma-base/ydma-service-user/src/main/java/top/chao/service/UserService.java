package top.chao.service;

import top.chao.common.ResultJson;
import top.chao.entity.User;

public interface UserService {
	/**
	 * 根据id查找用户
	 * @param id
	 * @return
	 */
	public ResultJson loadUser(int id);

	/**
	 * 用户注册(用户名，密码)
	 * @param name
	 * @param password
	 * @return
	 */
	public ResultJson addUser(String name, String password);

	/**
	 * 用户登录(用户名，密码)
	 * @param name
	 * @param password
	 * @return
	 */
	public ResultJson checkUser(String name, String password);
	
	/**
	 * 检查Token
	 * @param token
	 * @return
	 */
	public ResultJson checkToken(String token);
	
	/**
	 * 用户更新资料
	 * @param token 
	 * @param user
	 * @return
	 */
	public ResultJson modifyUser(String token, User user);

	/**
	 * 用户修改密码
	 * @param token
	 * @param password
	 * @param new_password 
	 * @return
	 */
	public ResultJson modifyPassword(String token, String password, String new_password);

	/**
	 * 登录历史记录
	 * @param token
	 * @return
	 */
	public ResultJson loadLoginHistory(String token);


}
