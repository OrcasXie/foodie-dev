package com.orcas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: Orcas
 * @version:1.0.0
 * @date: 2020/10/3 17:42
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    /**
     * Swagger2 核心配置 docket
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)  // 指定API类型
                .apiInfo(apiInfo())                     // 定义API文档汇总信息
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.orcas.controller"))  // 指定 controller 包
                .paths(PathSelectors.any())             // 选择包下所有的 controller
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("萌宠购 接口api文档")
                .description("关于萌宠购商城的api文档")
                .contact(new Contact("Orcas",
                        "https://blog.csdn.net/u012211603",
                        "test@163.com"))                         // 联系人信息
                .termsOfServiceUrl("https://blog.csdn.net/u012211603") // 网站地址
                .version("1.0.0")                                      // 版本号
                .build();
    }
}
