/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package com.antmeite;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring4all.swagger.EnableSwagger2Doc;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * zuul 网关服务
 * @EnableZuulProxy    开启网关
 * @EnableSwagger2Doc  开启swagger api接口文档服务
 */
@RestController
@SpringBootApplication
@EnableZuulProxy
@EnableSwagger2Doc
public class AppZuul {

	public static void main(String[] args) {
		SpringApplication.run(AppZuul.class, args);
	}

	@RequestMapping("/")
	public String gateway() {
		return "微服务电商项目-网关服务启动成功......";
	}

	@Component
	@Primary
	class DocumentationConfig implements SwaggerResourcesProvider {
		@Override
		public List<SwaggerResource> get() {
			List resources = new ArrayList<>();
			// app-itmayiedu-order
			resources.add(swaggerResource("/api-member", "/app-member/v2/api-docs", "2.0"));
			resources.add(swaggerResource("/api-order", "/app-order/v2/api-docs", "2.0"));
			resources.add(swaggerResource("/api-stock", "/app-stock/v2/api-docs", "2.0"));
			return resources;
		}

		private SwaggerResource swaggerResource(String name, String location, String version) {
			SwaggerResource swaggerResource = new SwaggerResource();
			swaggerResource.setName(name);
			swaggerResource.setLocation(location);
			swaggerResource.setSwaggerVersion(version);
			return swaggerResource;
		}
	}

}
