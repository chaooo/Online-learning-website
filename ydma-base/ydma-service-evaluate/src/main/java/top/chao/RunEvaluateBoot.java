package top.chao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAsync(proxyTargetClass=true) //强制使用基于CGLib
@EnableTransactionManagement // 开启注解事务管理
@SpringBootApplication
@MapperScan(basePackages="top.chao.dao")
public class RunEvaluateBoot {

	public static void main(String[] args) {
		SpringApplication.run(RunEvaluateBoot.class, args);

	}

}
