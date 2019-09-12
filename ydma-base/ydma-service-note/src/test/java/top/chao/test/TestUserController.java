package top.chao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


import junit.framework.TestCase;

import top.chao.RunNoteBoot;

import top.chao.common.ResultEnum;
import top.chao.common.ResultJson;
import top.chao.controller.NoteController;
import top.chao.entity.Note;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=RunNoteBoot.class)
public class TestUserController {
	@Autowired
	private NoteController controller;
	/**
	 * 测试SpringMVC处理流程 主要逻辑
	 * @param uri
	 * @param params
	 * @param enumMsg
	 * @throws Exception
	 */
	private void testHttp(String type, String uri, MultiValueMap<String, String> params, String enumMsg) throws Exception {
		//创建MockMvc对象，可以发送HTTP请求，接收响应结果
		MockMvc mock = MockMvcBuilders.standaloneSetup(controller).build();
		//使用mock对象发送POST请求
		RequestBuilder request = null;
		if("post".equals(type)) {
			if(params==null) request = MockMvcRequestBuilders.post(uri);
			else request = MockMvcRequestBuilders.post(uri).params(params);
		}
		if("get".equals(type)) {
			if(params==null) request = MockMvcRequestBuilders.get(uri);
			else request = MockMvcRequestBuilders.get(uri).params(params);
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
	/**
	 *  测试SpringMVC处理流程Post JSON字符串
	 */
	private void testHttpJsonStr(String uri, String params, String enumMsg) throws Exception {
		//创建MockMvc对象，可以发送HTTP请求，接收响应结果
		MockMvc mock = MockMvcBuilders.standaloneSetup(controller).build();
		//使用mock对象发送POST请求
		RequestBuilder request = MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(params);
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

	
	
	
	//测试SpringMVC处理添加笔记流程
	@Test
	public void testAddNote1() throws Exception {
		//配置参数
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("context", "hahahah");
		params.set("like_count", "123");
		params.set("title", "hhah");
		params.set("user_id", "1");
		params.set("video_id", "1");
		params.set("publish_time", null);
		String msg = ResultEnum.INSERT_SUCCESS.getMsg();
		//测试
		testHttp("post", "/note/add", params, msg);
	}




	
	//测试SpringMVC处理添加笔记流程
	@Test
	public void testAddNote2() throws Exception {
		//配置参数
		Note record = new Note();
		record.setContext("hahahah");
		record.setLike_count(123);
		record.setTitle("hehe");
		record.setUser_id(1);
		record.setVideo_id(1);
		record.setPublish_time(null);
		Gson g = new Gson();
		String params = g.toJson(record);
		System.out.println(params);
		String msg = ResultEnum.INSERT_SUCCESS.getMsg();
		//测试
		testHttpJsonStr("/note/add", params, msg);
	}
	
}
