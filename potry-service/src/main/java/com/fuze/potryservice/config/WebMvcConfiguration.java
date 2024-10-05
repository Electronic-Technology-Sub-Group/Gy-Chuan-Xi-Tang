package com.fuze.potryservice.config;

import com.fuze.json.JacksonObjectMapper;
import com.fuze.potryservice.interceptor.JwtTokenUserInterceptor;
import org.aopalliance.intercept.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
@Autowired
    private JwtTokenUserInterceptor jwtTokenUserInterceptor;


//先拦截所有路径
//protected void addInterceptors(InterceptorRegistry registry) {
//    System.out.println(jwtTokenUserInterceptor);
//registry.addInterceptor(jwtTokenUserInterceptor)
//        .addPathPatterns("/user/**")
//        .excludePathPatterns("/user/login");
//
//}
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
//扩展spring mvc 的配置

    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new JacksonObjectMapper());
        converters.add(0,converter);
    }



}