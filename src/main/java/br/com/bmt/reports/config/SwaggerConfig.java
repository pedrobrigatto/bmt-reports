package br.com.bmt.reports.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private static final String SERVICE_TITLE = "Building Management Tool";
	private static final String SERVICE_DESCRIPTION = "Ferramenta para gerenciamento de obras";
	private static final String SERVICE_VERSION = "1.0";
	private static final String CONTROLLERS_PACKAGE = "br.com.bmt.reports.controllers";
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().
				apis(RequestHandlerSelectors.basePackage(CONTROLLERS_PACKAGE)).
				paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(SERVICE_TITLE).
				description(SERVICE_DESCRIPTION).version(SERVICE_VERSION).build();
	}
}
