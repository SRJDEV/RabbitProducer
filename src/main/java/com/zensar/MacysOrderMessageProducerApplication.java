package com.zensar;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class MacysOrderMessageProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MacysOrderMessageProducerApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();

	}

	@Bean
	public Docket getCustomizedDocket() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.zensar")).paths(PathSelectors.any()).build();

	}

	private ApiInfo getApiInfo() {
		
		return new ApiInfo("Advertise API Documentation",
				"Advertise API Documentatio by Zensar",
				"1.0",
				"zensar.com/termsofservice",
				new Contact("Anand", "http://zensar.com","anand@zensar.com"),
				"GPL",
				"sss.com",
				new ArrayList<VendorExtension>());
	}

//	@Bean
//	public Docket getCustomisedDocket() {
//		
//		
//		return new Docket(DocumentationType.SWAGGER_2)
//				.apiInfo(getApiIfo())
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.zensar"))
//				.paths(PathSelectors.any())
//				.build();
//				
//	}
//	
//	private ApiInfo getApiIfo() {
//		return new ApiInfo(
//				"Advertise API Documentation",
//				"Advertise API Documentatio by Zensar",
//				"1.0",
//				"zensar.com/termsofservice",
//				new Contact("Anand", "http://zensar.com","anand@zensar.com"),
//				"GPL",
//				"sss.com",
//				new ArrayList<VendorExtension>());
//		
//	}

}
