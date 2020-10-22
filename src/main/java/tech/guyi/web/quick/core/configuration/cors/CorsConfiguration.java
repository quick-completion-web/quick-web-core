package tech.guyi.web.quick.core.configuration.cors;

import lombok.Data;

import java.util.Collections;
import java.util.Set;

/**
 * @author guyi
 * 跨域配置
 */
@Data
public class CorsConfiguration {

    /**
     * 是否启用
     */
    private boolean enable;
    private String mapping = "/**";
    private Set<String> origins = Collections.singleton("*");
    private boolean credentials = true;
    private Set<String> methods = Collections.singleton("*");
    private Set<String> headers = Collections.singleton("*");
    private Set<String> exposedHeaders = Collections.singleton("*");


}
