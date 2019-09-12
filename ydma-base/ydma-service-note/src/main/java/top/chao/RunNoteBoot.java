package top.chao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAsync(proxyTargetClass=true)
@EnableTransactionManagement
@SpringBootApplication
@MapperScan(basePackages = "top.chao.dao")
public class RunNoteBoot {

	public static void main(String[] args) {
		SpringApplication.run(RunNoteBoot.class, args);

	}

}
