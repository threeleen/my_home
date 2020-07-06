/**
 * @Project Name: myre
 * @File Name: InterceptorConfig
 * @author wangzhihao E-mail: w15603919702@gmail.com
 * @date 2020-06-29 10:00 PM
 * @version 1.0
 * @By IDE: IntelliJ IDEA
 */
package com.review.myre.myre_interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        System.out.println("添加拦截器");
        registry.addInterceptor(authenticationInterceptor())
                         .addPathPatterns("/**");

    }


    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
                return new AuthenticationInterceptor();// 自己写的拦截器
            }


}
