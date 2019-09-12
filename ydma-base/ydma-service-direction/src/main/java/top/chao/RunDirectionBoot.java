package top.chao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan(basePackages="top.chao.dao")
public class RunDirectionBoot {

	public static void main(String[] args) {
		SpringApplication.run(RunDirectionBoot.class, args);
	}
	
	// 解决服务与服务调用的问题
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
