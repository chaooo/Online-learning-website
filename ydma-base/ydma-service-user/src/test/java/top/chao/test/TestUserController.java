package top.chao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.TestCase;
import top.chao.RunUserBoot;
import top.chao.common.ResultEnum;
import top.chao.common.ResultJson;
import top.chao.controller.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=RunUserBoot.class)
public class TestUserController {
	
	@Autowired
	private UserController controller;
	/**
	 * 测试SpringMVC处理流程 主要逻辑
	 * @param uri
	 * @param params
	 * @param enumMsg
	 * @throws Exception
	 */
	private void testHttp(String type, String uri, MultiValueMap<String, String> params, String enumMsg, String token) throws Exception {
		//创建MockMvc对象，可以发送HTTP请求，接收响应结果
		MockMvc mock = MockMvcBuilders.standaloneSetup(controller).build();
		//使用mock对象发送POST请求
		RequestBuilder request = null;
		if("post".equals(type)) {
			if(params==null) request = MockMvcRequestBuilders.post(uri).header("token", token!=null?token:"test");
			else request = MockMvcRequestBuilders.post(uri).params(params).header("token", token!=null?token:"test");
		}
		if("get".equals(type)) {
			if(params==null) request = MockMvcRequestBuilders.get(uri).header("token", token!=null?token:"test");
			else request = MockMvcRequestBuilders.get(uri).params(params).header("token", token!=null?token:"test");
		}
		MvcResult result = mock.perform(request).andReturn();
		//获取返回的结果
		String jsonStr = result.getResponse().getContentAsString();
		//将返回jsonStr结果转成ResultJson对象
		ObjectMapper mapper = new ObjectMapper();
		ResultJson resultJson = mapper.readValue(jsonStr, ResultJson.class);
		
		System.out.println(resultJson);
		//使用断言比对结果和预期
		TestCase.assertEquals(enumMsg, resultJson.getMsg());
	}
	
	//测试注册
	@Test
	public void testRegister() throws Exception {
		//配置参数
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("name", "chao2");
		params.set("password", "123456");
		String msg = ResultEnum.INSERT_SUCCESS.getMsg();
		//测试
		testHttp("post", "/user/regist", params, msg, null);
	}
	
	//测试登录
	@Test
	public void testLogin() throws Exception {
		//配置参数
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("name", "chao2");
		params.set("password", "123456");
		String msg = ResultEnum.LOGIN_SUCCESS.getMsg();
		//测试
		testHttp("post", "/user/login", params, msg, null);
	}

	
	//测试token
	@Test
	public void testJWT() throws Exception {
		//配置参数
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJjaGFvIiwidWlkIjoyOSwiZXhwIjoxNTY3OTM2NzgwfQ.6zvimBNs_MCiov4MOkkUodgKmRFBS2dVhmhIb1MV6m4");
		String msg = ResultEnum.TOKEN_SUCCESS.getMsg();
		//测试
		testHttp("post", "/user/token", params, msg, null);
	}
	
	//测试用户资料更新
	@Test
	public void testUPDATE() throws Exception {	
		//配置参数
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("nick_name", "test");
		params.set("sex", "男");
		String msg = ResultEnum.UPDATE_SUCCESS.getMsg();
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJjaGFvIiwidWlkIjoyOSwiZXhwIjoxNTY3OTM2NzgwfQ.6zvimBNs_MCiov4MOkkUodgKmRFBS2dVhmhIb1MV6m4";
		//测试
		testHttp("post", "/user/update", params, msg, token);
	}
	
	//测试用户修改密码
	@Test
	public void testPWD() throws Exception {	
		//配置参数
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("password", "12345678");
		params.set("new_password", "123456");
		String msg = ResultEnum.MODIFY_SUCCESS.getMsg();
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJjaGFvIiwidWlkIjoyOSwiZXhwIjoxNTY3OTM2NzgwfQ.6zvimBNs_MCiov4MOkkUodgKmRFBS2dVhmhIb1MV6m4";
		//测试
		testHttp("post", "/user/password", params, msg, token);
	}

	//登陆记录
	@Test
	public void testloadLoginHistory() throws Exception {
		String msg = ResultEnum.QUERY_SUCCESS.getMsg();
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJjaGFvIiwidWlkIjoyOSwiZXhwIjoxNTY4MDIwNDkwfQ.5RYMMPbvTxdVdpdm2GO2bX7oCE7VadygUhTTaILnFUY";
		//测试
		testHttp("get", "/user/history/login", null, msg, token);
	}

}
