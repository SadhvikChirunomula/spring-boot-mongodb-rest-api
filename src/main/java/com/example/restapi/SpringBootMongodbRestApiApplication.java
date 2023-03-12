package com.example.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableSwagger2
@SpringBootApplication
public class SpringBootMongodbRestApiApplication {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.paths(PathSelectors.any()).build().pathMapping("/")
				.apiInfo(apiInfo()).useDefaultResponseMessages(false);
	}

	@Bean
	ApiInfo apiInfo() {
		final ApiInfoBuilder builder = new ApiInfoBuilder();
		builder.title("Mongo CRUD API").version("2.0").license("")
				.description("Mongo CRUD API");
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongodbRestApiApplication.class, args);
	}

}

