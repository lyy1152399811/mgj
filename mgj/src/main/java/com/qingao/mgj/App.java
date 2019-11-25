package com.qingao.mgj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.qingao.mgj")
@MapperScan(value = "com.qingao.mgj.mapper")
public class App 
{
 public static void main(String[] args) throws Exception {
	SpringApplication.run(App.class, args);
}

}
