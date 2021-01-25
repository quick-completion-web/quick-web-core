package tech.guyi.web.quick.core.configuration.cors;

import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
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
    private boolean credentials = true;
    private Set<String> methods = Collections.singleton("*");
    private Set<String> headers = Collections.singleton("*");
    private Set<String> exposedHeaders = new HashSet<>(
            Arrays.asList(
                    "DNT",
                    "X-Mx-ReqToken",
                    "Keep-Alive",
                    "User-Agent",
                    "X-Requested-With",
                    "If-Modified-Since",
                    "Cache-Control",
                    "Content-Type",
                    "Authorization"
            )
    );


}
