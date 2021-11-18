package com.nace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class NaceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaceServiceApplication.class, args);


	}

	@Bean
	public Docket swaggerConfiguration()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/details/*"))
				.apis(RequestHandlerSelectors.basePackage("com.nace"))
				.build()
				.apiInfo(apiInfo());


	}
	public ApiInfo apiInfo() {
		return new ApiInfo(" Nace Service", "Simple Micro service", "0.0.1",
				"mail@mail.com", "mail@mail.com", " ", " ");

	}



}
