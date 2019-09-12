package top.chao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages="top.chao.dao")
public class RunCourseBoot {

	public static void main(String[] args) {
		SpringApplication.run(RunCourseBoot.class, args);

	}

}
