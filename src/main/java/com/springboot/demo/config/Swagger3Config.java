package com.springboot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDate;

@Configuration
public class Swagger3Config {
    @Bean
    public Docket petApi() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("SpringBoot-Demo")
                .contact(new Contact("xxx","https:111.com","111@qq.com"))
                .license("Apache 2.0")
                .licenseUrl("https:222.com")
                .version("1.0")
                .termsOfServiceUrl("服务条款Url")
                .build();

        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .enableUrlTemplating(true);
    }
}
