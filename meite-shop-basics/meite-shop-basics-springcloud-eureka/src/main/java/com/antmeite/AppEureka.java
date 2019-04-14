/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package com.antmeite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *  eureka 注册中心服务
 *  @EnableEurekaServer  开启eureka 服务器端
 */
@SpringBootApplication
@EnableEurekaServer
public class AppEureka {

	public static void main(String[] args) {
		SpringApplication.run(AppEureka.class, args);
	}

}
