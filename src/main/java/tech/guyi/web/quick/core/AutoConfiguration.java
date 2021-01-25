package tech.guyi.web.quick.core;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tech.guyi.web.quick.core.configuration.cors.CorsConfiguration;
import tech.guyi.web.quick.core.controller.converter.HttpEntityResponseBodyConverter;
import tech.guyi.web.quick.core.controller.exception.DefaultExceptionHandler;

import javax.annotation.Resource;

/**
 * @author guyi
 * 核心包自动配置
 */
@Configuration
public class AutoConfiguration implements WebMvcConfigurer {

    @Resource
    private CorsConfiguration corsConfiguration;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if (corsConfiguration.isEnable()){
            registry.addMapping(corsConfiguration.getMapping())
                    .allowedOriginPatterns("*")
                    .allowCredentials(corsConfiguration.isCredentials())
                    .allowedMethods(corsConfiguration.getMethods().toArray(new String[0]))
                    .allowedHeaders(corsConfiguration.getHeaders().toArray(new String[0]))
                    .exposedHeaders(corsConfiguration.getExposedHeaders().toArray(new String[0]));
        }
    }

    @Bean
    @ConditionalOnProperty(value = "tech.guyi.web.quick.response.converter.enable", havingValue = "true")
    public HttpEntityResponseBodyConverter httpEntityResponseBodyConverter(){
        return new HttpEntityResponseBodyConverter();
    }

    @Bean
    @ConditionalOnProperty(value = "tech.guyi.web.quick.response.exception.handler.enable", havingValue = "true")
    public DefaultExceptionHandler defaultExceptionHandler(){
        return new DefaultExceptionHandler();
    }

}
