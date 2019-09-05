package top.chao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import top.chao.common.ResultJson;
import top.chao.entity.User;
import top.chao.service.UserService;

@RestController
public class UserController {
	/**
	 * 注入服务类
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * 根据id查找用户
	 * @param id
	 * @return
	 */
	@GetMapping("/user/get")
	public ResultJson load(int id) {
		return userService.loadUser(id);
	}
	
	/**
	 * 用户注册(用户名，密码)
	 * @param name
	 * @param password
	 * @return
	 */
	@PostMapping("/user/regist")
	public ResultJson regist(String name, String password) {
		return userService.addUser(name, password);
	}

	/**
	 * 用户登录(用户名，密码)
	 * @param name
	 * @param password
	 * @return
	 */
	@PostMapping("/user/login")
	public ResultJson login(String name, String password) {
		return userService.checkUser(name, password);
	}
	
	/**
	 * 用户更新资料
	 * @param user
	 * @return
	 */
	@PostMapping("/user/update")
	public ResultJson update(User user) {
		return userService.modifyUser(user);
	}

	/**
	 * 检查Token
	 * @param token
	 * @return
	 */
	@PostMapping("/user/token")
	public ResultJson verifyToken(String token) {
		return userService.checkToken(token);
	};
}
