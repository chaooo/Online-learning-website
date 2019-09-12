package top.chao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import top.chao.common.ResultJson;
import top.chao.service.DirectionService;

@RestController
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST})
public class DirectionController {
	/**
	 * 注入服务类
	 */
	@Autowired
	private DirectionService directionService;
	
	/**
	 * 查询所有方向及其下的科目
	 * @return
	 */
	@GetMapping("/direction/all")
	public ResultJson loadAll() {
		return directionService.loadAll();
	}
	

}
