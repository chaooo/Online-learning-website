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
public class TestNoteController {
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
	
	//测试修改笔记操作
	@Test
	public void testModifyNote() throws Exception {
		//配置参数
		Note record = new Note();
		record.setContext("你大爷");
		record.setId(1);
		Gson g = new Gson();
		String params = g.toJson(record);
		System.out.println(params);
		String msg = ResultEnum.INSERT_SUCCESS.getMsg();
		//测试
		testHttpJsonStr("/note/modify", params, msg);
	}
	
	//测试笔记删除功能
	@Test
	public void testDeleteNote() throws Exception {
		//配置参数
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("id", "32");
		String msg = ResultEnum.INSERT_SUCCESS.getMsg();
		//测试
		testHttp("post", "/note/delete", params, msg);
	}
	
	//收藏笔记测试功能1：已收藏的笔记
	@Test
	public void testCollectNote1() throws Exception {
		//配置参数
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("user_id", "3");
		params.set("note_id", "10");
		String msg = ResultEnum.COLLECT_ERROR.getMsg();
		//测试
		testHttp("post", "/note/collect", params, msg);
	}
	
	//收藏笔记测试功能1：收藏笔记成功
	@Test
	public void testCollectNote2() throws Exception {
		//配置参数
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("user_id", "3");
		params.set("note_id", "14");
		String msg = ResultEnum.COLLECT_SUCCESS.getMsg();
		//测试
		testHttp("post", "/note/collect", params, msg);
	}
	
	//取消收藏笔记功能测试:取消收藏失败
	@Test
	public void testCancelCollectNote1() throws Exception {
		//配置参数
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("user_id", "3");
		params.set("note_id", "14");
		String msg = ResultEnum.CANCELCOLLECT_ERROR.getMsg();
		//测试
		testHttp("post", "/note/cancelCollect", params, msg);
	}
	
	//取消收藏笔记功能测试:取消收藏成功
	@Test
	public void testCancelCollectNote2() throws Exception {
		//配置参数
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("user_id", "3");
		params.set("note_id", "13");
		String msg = ResultEnum.CANCELCOLLECT_SUCCESS.getMsg();
		//测试
		testHttp("post", "/note/cancelCollect", params, msg);
	}
	
	//笔记点赞功能测试
	@Test
	public void testNoteLike() throws Exception {
		//配置参数
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("user_id", "1");
		params.set("note_id", "1");
		String msg = ResultEnum.LIKE_SUCCESS.getMsg();
		//测试
		testHttp("post", "/note/noteLike", params, msg);
	}

	//取消笔记点赞功能测试
	@Test
	public void testCancelNoteLike() throws Exception {
		//配置参数
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("user_id", "1");
		params.set("note_id", "1");
		String msg = ResultEnum.CANCELLIKE_SUCCESS.getMsg();
		//测试
		testHttp("post", "/note/cancelLike", params, msg);
	}
	
	//笔记收藏夹
	@Test
	public void testLoadCollectNote() throws Exception {
		String msg = ResultEnum.QUERY_SUCCESS.getMsg();
		//测试
		testHttp("get", "/note/collect/get", null, msg);
	}
	
}
