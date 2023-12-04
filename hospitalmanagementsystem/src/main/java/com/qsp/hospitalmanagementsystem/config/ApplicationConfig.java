package com.qsp.hospitalmanagementsystem.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//URL OF A SWAGGER : http://localhost:8080/swagger-ui.html#
@Configuration
@EnableSwagger2
public class ApplicationConfig {
	@Bean
	public Docket getDocket() {
		Contact contact = new Contact("Qspider", "http://qspiders.com", "qspider@gmail.com");
		List<VendorExtension> vendorExtensions = new ArrayList<VendorExtension>();
		ApiInfo apiInfo = new ApiInfo("hospitalmanagementsystem",
				"This Is Used To Maintain And Manage The Details Of The Patients In An Hospital", "Version 1.0",
				"1 year of free service", contact, "QSP7896", "http://qsp001.com", vendorExtensions);
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.qsp.hospitalmanagementsystem")).build().apiInfo(apiInfo).useDefaultResponseMessages(false);
	}
}