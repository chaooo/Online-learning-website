package top.chao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="top.chao.dao")
public class RunDirectionBoot {

	public static void main(String[] args) {
		SpringApplication.run(RunDirectionBoot.class, args);

	}

}
