package tech.guyi.web.quick.core.controller.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.guyi.web.quick.core.configuration.response.ResponseExceptionHandlerConfiguration;
import tech.guyi.web.quick.core.configuration.response.ResponseMessageConfiguration;
import tech.guyi.web.quick.core.controller.ResponseContent;
import tech.guyi.web.quick.core.controller.ResponseEntities;

import javax.annotation.Resource;

/**
 * @author guyi
 * 默认异常处理器
 */
@ControllerAdvice
public class DefaultExceptionHandler {

    @Resource
    private ResponseExceptionHandlerConfiguration configuration;
    @Resource
    private ResponseMessageConfiguration messageConfiguration;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseContent<Void>> exceptionHandler(Exception e){
        if (configuration.isStackTrace()){
            e.printStackTrace();
        }
        return ResponseEntities.fail(StringUtils.isEmpty(e.getMessage()) ?
                messageConfiguration.getServerErrorMessage() : e.getMessage());
    }

}
