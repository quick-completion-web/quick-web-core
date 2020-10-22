package tech.guyi.web.quick.core.configuration.response;

import lombok.Data;

/**
 * @author guyi
 * 响应异常处理器配置
 */
@Data
public class ResponseExceptionHandlerConfiguration {

    private boolean enable;
    private boolean stackTrace;

}
