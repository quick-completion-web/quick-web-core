package tech.guyi.web.quick.core.configuration.response;

import lombok.Data;

/**
 * @author guyi
 * 响应消息配置
 */
@Data
public class ResponseMessageConfiguration {

    /**
     * 当抛出异常且没有异常Message时使用的默认提示
     */
    private String serverErrorMessage = "服务器异常错误";

}
