package tech.guyi.web.quick.core.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.guyi.web.quick.core.configuration.cors.CorsConfiguration;
import tech.guyi.web.quick.core.configuration.response.ResponseConverterConfiguration;
import tech.guyi.web.quick.core.configuration.response.ResponseExceptionHandlerConfiguration;
import tech.guyi.web.quick.core.configuration.response.ResponseMessageConfiguration;

@Configuration
public class ConfigurationAutoConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "tech.guyi.web.quick")
    public CoreConfiguration coreConfiguration(){
        return new CoreConfiguration();
    }

    @Bean
    @ConfigurationProperties(prefix = "tech.guyi.web.quick.response.converter")
    public ResponseConverterConfiguration responseConverterConfiguration(){
        return new ResponseConverterConfiguration();
    }

    @Bean
    @ConfigurationProperties(prefix = "tech.guyi.web.quick.response.message")
    public ResponseMessageConfiguration responseMessageConfiguration(){
        return new ResponseMessageConfiguration();
    }

    @Bean
    @ConfigurationProperties(prefix = "tech.guyi.web.quick.response.exception.handler")
    public ResponseExceptionHandlerConfiguration responseExceptionHandlerConfiguration(){
        return new ResponseExceptionHandlerConfiguration();
    }

    @Bean
    @ConfigurationProperties(prefix = "tech.guyi.web.quick.cors")
    public CorsConfiguration corsConfiguration(){
        return new CorsConfiguration();
    }

}
