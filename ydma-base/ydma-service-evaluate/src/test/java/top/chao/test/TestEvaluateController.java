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
import top.chao.RunEvaluateBoot;
import top.chao.common.ResultEnum;
import top.chao.common.ResultJson;
import top.chao.controller.EvaluateController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=RunEvaluateBoot.class)
public class TestEvaluateController {
		
		@Autowired
		private EvaluateController controller;
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
		//测试 
		@Test
		public void testloadEvaluateByVideoId() throws Exception {
			//配置参数
			MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
			params.set("page", "1");
			params.set("size", "5");
			params.set("video_id", "11");
			String msg = ResultEnum.QUERY_SUCCESS.getMsg();
			//测试
			testHttp("get", "/evaluate/video", params, msg);
		}
		//测试  
		@Test
		public void testloadEvaluateByCourseId() throws Exception {
			//配置参数
			MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
			params.set("page", "1");
			params.set("size", "5");
			params.set("course_id", "1");
			String msg = ResultEnum.QUERY_SUCCESS.getMsg();
			//测试
			testHttp("get", "/evaluate/course", params, msg);
		}
		//测试
		@Test
		public void testupdateEvaluateAddLike() throws Exception {
			//配置参数
			MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
			params.set("id", "1");
			String msg = ResultEnum.LIKE_SUCCESS.getMsg();
			//测试
			testHttp("post", "/course/like", params, msg);
		}
}
