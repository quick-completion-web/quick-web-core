package tech.guyi.web.quick.core.controller.converter;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import tech.guyi.web.quick.core.controller.ResponseContent;
import tech.guyi.web.quick.core.controller.ResponseEntities;

/**
 * @author guyi
 * Http响应统一格式修改
 */
@RestControllerAdvice
public class HttpEntityResponseBodyConverter implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter parameter, Class<? extends HttpMessageConverter<?>> converter) {
        return MappingJackson2HttpMessageConverter.class.isAssignableFrom(converter);
    }

    @Override
    public Object beforeBodyWrite(Object object, MethodParameter parameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> classes, ServerHttpRequest request, ServerHttpResponse response) {
        if (object instanceof ResponseContent){
            return object;
        }
        return ResponseEntities.ok(object).getBody();
    }

}
