package top.chao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.chao.common.ResultEnum;
import top.chao.common.ResultJson;
import top.chao.dao.LoginHistoryMapper;
import top.chao.dao.UserMapper;
import top.chao.entity.LoginHistory;
import top.chao.entity.User;
import top.chao.service.UserService;
import top.chao.util.JwtUtil;
import top.chao.util.MD5Util;

@Service
public class UserServiceImpl implements UserService {
	/**
	 * 注入DAO
	 */
	@Autowired
	private UserMapper userDao;
	@Autowired
	private LoginHistoryMapper loginHistoryDao;
	
	/**
	 * 根据id查找用户
	 * @param id
	 * @return
	 */
	@Override
	public ResultJson loadUser(int id) {
		ResultJson result = new ResultJson();
		User user = userDao.selectByPrimaryKey(id);
		if(user!=null) {
			result.setCode(ResultEnum.QUERY_SUCCESS.getCode());
			result.setMsg(ResultEnum.QUERY_SUCCESS.getMsg());
			result.setData(user);
		}else {
			result.setCode(ResultEnum.QUERY_ERROR.getCode());
			result.setMsg(ResultEnum.QUERY_ERROR.getMsg());
		}
		return result;
	}
	/**
	 * 用户注册(用户名，密码)
	 * @param name
	 * @param password
	 * @return
	 */
	@Override
	public ResultJson addUser(String name, String password) {
		ResultJson result = new ResultJson();
		//检查用户名是否被占用
		User user = userDao.selectByName(name);
		if(user!=null) {
			result.setCode(ResultEnum.RGIST_NAME_ERROR.getCode());
			result.setMsg(ResultEnum.RGIST_NAME_ERROR.getMsg());
			return result;
		}
		//添加用户信息
		user = new User();
		//设置用户名
		user.setName(name);
		//密码加密后再保存
		String salt = MD5Util.salt();
		String md5Password = MD5Util.md5(password+salt);
		user.setPassword(md5Password);
		user.setSalt(salt);
		//设置注册时间
		user.setRegtime(new Date());
		//添加到数据库
		int row = userDao.insertSelective(user);
		//返回信息
		if(row>0) {
			result.setCode(ResultEnum.INSERT_SUCCESS.getCode());
			result.setMsg(ResultEnum.INSERT_SUCCESS.getMsg());
			result.setData(user);
		}else {
			result.setCode(ResultEnum.INSERT_ERROR.getCode());
			result.setMsg(ResultEnum.INSERT_ERROR.getMsg());
		}
		return result;
	}
	/**
	 * 用户登录(用户名，密码)
	 * @param name
	 * @param password
	 * @return
	 */
	@Override
	public ResultJson checkUser(String name, String password) {
		ResultJson result = new ResultJson();
		//处理比对密码
		User user = userDao.selectByName(name);
		if(user!=null) {
			String  salt = user.getSalt();
			String md5Password = MD5Util.md5(password+salt);
			String dbPassword = user.getPassword();
			if(md5Password.equals(dbPassword)) {
				//生成token给用户
				String token = JwtUtil.createToken(user);//15分钟有效期
				result.setCode(ResultEnum.LOGIN_SUCCESS.getCode());
				result.setMsg(ResultEnum.LOGIN_SUCCESS.getMsg());
				result.setData(token);
				return result;
			}
		}
		result.setCode(ResultEnum.LOGIN_ERROR.getCode());
		result.setMsg(ResultEnum.LOGIN_ERROR.getMsg());
		return result;
	}
	
	/**
	 * 检查Token
	 * @param token
	 * @return
	 */
	@Override
	public ResultJson checkToken(String token) {
		ResultJson result = new ResultJson();
		boolean ok = JwtUtil.isVerify(token);
		if(ok) {
			result.setCode(ResultEnum.TOKEN_SUCCESS.getCode());
			result.setMsg(ResultEnum.TOKEN_SUCCESS.getMsg());
			return result;
		}
		result.setCode(ResultEnum.TOKEN_ERROR.getCode());
		result.setMsg(ResultEnum.TOKEN_ERROR.getMsg());
		return result;
	}
	
	/**
	 * 用户更新资料
	 * @param user
	 * @return
	 */
	@Override
	public ResultJson modifyUser(String token, User user) {
		//先检查token，若Token令牌错误，返回
		ResultJson result = checkToken(token);
		if(result.getCode()!=0) return result;
		//根据token得到用户id,并查出用户数据
		int user_id = JwtUtil.parseTokenUid(token);
		user.setId(user_id);
		int rows = userDao.updateByPrimaryKeySelective(user);
		if(rows>0) {
			result.setCode(ResultEnum.UPDATE_SUCCESS.getCode());
			result.setMsg(ResultEnum.UPDATE_SUCCESS.getMsg());
			return result;
		}
		result.setCode(ResultEnum.UPDATE_ERROR.getCode());
		result.setMsg(ResultEnum.UPDATE_ERROR.getMsg());
		return result;
	}
	
	/**
	 * 用户修改密码
	 * @param password
	 * @param new_password
	 * @return
	 */
	@Override
	public ResultJson modifyPassword(String token, String password, String new_password) {
		//先检查token，若Token令牌错误，返回
		ResultJson result = checkToken(token);
		if(result.getCode()!=0) return result;
		//根据id查找用户
		int user_id = JwtUtil.parseTokenUid(token);
		User user = userDao.selectByPrimaryKey(user_id);
		//判断旧密码是否输入正确
		String old_password = user.getPassword();
		if(password.equals(old_password)) {
			result.setCode(ResultEnum.OLD_PASSWORD_ERROR.getCode());
			result.setMsg(ResultEnum.OLD_PASSWORD_ERROR.getMsg());
			return result;
		}
		//新密码加密后再保存
		String salt = MD5Util.salt();
		String md5Password = MD5Util.md5(new_password+salt);
		user.setPassword(md5Password);
		user.setSalt(salt);
		//更新到数据库
		int rows = userDao.updateByPrimaryKeySelective(user);
		if(rows>0) {
			result.setCode(ResultEnum.MODIFY_SUCCESS.getCode());
			result.setMsg(ResultEnum.MODIFY_SUCCESS.getMsg());
			return result;
		}
		result.setCode(ResultEnum.MODIFY_ERROR.getCode());
		result.setMsg(ResultEnum.MODIFY_ERROR.getMsg());
		return result;
	}
	
	/**
	 * 登录历史记录
	 */
	@Override
	public ResultJson loadLoginHistory(String token) {
		int user_id = JwtUtil.parseTokenUid(token);
		
		System.out.println(user_id);
		
		List<LoginHistory> list = loginHistoryDao.selectByUserId(user_id);
		ResultJson result = new ResultJson();
		if(list.isEmpty()) {
			result.setCode(ResultEnum.QUERY_ERROR.getCode());
			result.setMsg(ResultEnum.QUERY_ERROR.getMsg());	
			return result;
		}
		result.setData(list);
		result.setCode(ResultEnum.QUERY_SUCCESS.getCode());
		result.setMsg(ResultEnum.QUERY_SUCCESS.getMsg());
		return result;
	}
	


}
