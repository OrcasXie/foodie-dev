package com.orcas.config;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;

/**
 * @author: Orcas
 * @version:1.0.0
 * @date: 2020/10/3 20:49
 */
@Configuration
@NoArgsConstructor
public class CorsConfig {

    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:8080");

        // 设置是否发送 cookie 信息
        config.setAllowCredentials(true);
        return new CorsFilter(httpServletRequest -> (config));
    }

}
