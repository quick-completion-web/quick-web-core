package tech.guyi.web.quick.core.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guyi
 * Http响应实体
 * @param <T> 数据类型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseContent<T> {

    private int code;
    private boolean success;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String message;
    private T data;

}
