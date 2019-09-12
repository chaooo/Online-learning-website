package top.chao.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import top.chao.common.ResultJson;
import top.chao.entity.User;
import top.chao.service.UserService;

@RestController
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST})
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
	 * 检查Token
	 * @param token
	 * @return
	 */
	@PostMapping("/user/token")
	public ResultJson verifyToken(String token) {
		return userService.checkToken(token);
	}
	
	/**
	 * 用户更新资料
	 * @param user
	 * @return
	 */
	@PostMapping("/user/update")
	public ResultJson update(User user, HttpServletRequest request) {
		String token = request.getHeader("token");
		return userService.modifyUser(token, user);
	}
	
	/**
	 * 用户修改密码
	 * @param password
	 * @param new_password
	 * @return
	 */
	@PostMapping("/user/password")
	public ResultJson modifyPassword(String password, String new_password, HttpServletRequest request) {
		String token = request.getHeader("token");
		return userService.modifyPassword(token, password, new_password);
	}
	
	/**
	 * 登录历史记录
	 * @param request
	 * @return
	 */
	@GetMapping("/user/history/login")
	public ResultJson loadLoginHistory(HttpServletRequest request) {
		String token = request.getHeader("token");
		return userService.loadLoginHistory(token);
	}
	
	
	
}
