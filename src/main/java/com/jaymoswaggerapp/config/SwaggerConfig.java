package com.jaymoswaggerapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import springfox.documentation.service.*;
import springfox.documentation.spi.service.contexts.SecurityContext;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import static springfox.documentation.builders.PathSelectors.regex;


@EnableSwagger2
@Configuration
public class SwaggerConfig {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jaymoswaggerapp"))
                .paths(regex("/test.*"))
                .build()
                .apiInfo(metaInfo())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()));
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot Swagger Example API",
                "Spring Boot Swagger Example API for Youtube",
                "1.0",
                "Terms of Service",
                new Contact("TechPrimers", "https://www.youtube.com/TechPrimers",
                        "techprimerschannel@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html"
        );

        return apiInfo;
    }



    private ApiKey apiKey() {
        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }







//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.jaymoswaggerapp"))
//                .paths(PathSelectors.any())
//                .build().apiInfo(metaData());
//    }
//
//    private ApiInfo metaData() {
//        return new ApiInfoBuilder()
//                .title("Tech Interface - Spring Boot Swagger Configuration")
//                .description("\"Swagger configuration for application \"")
//                .version("1.1.0")
//                .license("Apache 2.0")
//                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
//                .contact(new Contact("Tech Interface", "https://www.youtube.com/channel/UCMpJ8m1w9t7EFcF9x8rs02A", "info@techinterface.com"))
//                .build();
//    }
    //for Swagger api doc generation
    //http://localhost:8091/v2/api-docs
}
