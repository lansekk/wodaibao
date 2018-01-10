package com.wodaibao.report.common.config;

import com.github.pagehelper.PageHelper;
import com.wodaibao.report.framework.GlobalInterceptor;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Properties;

/**
 * web配置
 */
@Configuration
@ServletComponentScan
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 分页
     *
     * @return PageHelper
     */
    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        // 通过设置pageSize=0或者RowBounds.limit = 0就会查询出全部的结果。
        p.setProperty("pageSizeZero", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
    @Bean
    public GlobalInterceptor globalInterceptor() {
        return new GlobalInterceptor();
    }
    /**
     * 注册拦截器
     *
     * @param registry InterceptorRegistry
     * 
     * @see WebMvcConfigurerAdapter#addInterceptors(InterceptorRegistry)
     *
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(globalInterceptor()).addPathPatterns("/v1/**").excludePathPatterns("/v1/login/**").excludePathPatterns("/v1/page/**");
    }

    /**
     * 跨域设置
     *
     * @param registry CorsRegistry
     * 
     * @see WebMvcConfigurerAdapter#addCorsMappings(CorsRegistry)
     *
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(false).allowedHeaders("http://localhost:9081/").maxAge(3600);
    }
}
