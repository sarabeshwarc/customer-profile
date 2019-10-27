package com.Q.customer.details;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig  {
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.Q.customer.details.controller"))              
          .paths(PathSelectors.any())
          .build()
          .apiInfo(getApiInfo());
    }
	
	private ApiInfo getApiInfo() {
	    return new ApiInfo(
	            "Customer Details",
	            "Allows to perform Delete, Update, Create and Read customer profile information.",
	            "V1",
	            "",
	            new Contact("Sarabeshwar Chandrasekar","","sarabeshwarc@gmail.com"),
	            "",
	            "",
	            Collections.emptyList()
	    );
	}

}
