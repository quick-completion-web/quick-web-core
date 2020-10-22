package tech.guyi.web.quick.core.controller;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author guyi
 * Http响应工具
 */
@Data
public class ResponseEntities {

    public static <T> ResponseEntity<ResponseContent<T>> create(ResponseContent<T> content){
        return create(content,HttpStatus.OK);
    }
    public static <T> ResponseEntity<ResponseContent<T>> create(ResponseContent<T> content, HttpStatus status){
        return new ResponseEntity<>(content,status);
    }

    public static <T> ResponseEntity<ResponseContent<T>> ok(){
        return create(new ResponseContent<>(0,true,null,null), HttpStatus.OK);
    }
    public static <T> ResponseEntity<ResponseContent<T>> ok(String message, T data){
        return create(new ResponseContent<>(0,true,message,data), HttpStatus.OK);
    }
    public static <T> ResponseEntity<ResponseContent<T>> ok(String message){
        return ok(message,null);
    }
    public static <T> ResponseEntity<ResponseContent<T>> ok(T data){
        return ok(null,data);
    }

    public static <T> ResponseEntity<ResponseContent<T>> fail(){
        return create(new ResponseContent<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),false,null,null), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    public static <T> ResponseEntity<ResponseContent<T>> fail(String message, T data){
        return create(new ResponseContent<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),false,message,data), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    public static <T> ResponseEntity<ResponseContent<T>> fail(String message){
        return fail(message,null);
    }
    public static <T> ResponseEntity<ResponseContent<T>> fail(T data){
        return fail(null,data);
    }

    public static <T> ResponseEntity<ResponseContent<T>> resourceNotFound(){
        return create(new ResponseContent<>(HttpStatus.NOT_FOUND.value(),false,null,null), HttpStatus.NOT_FOUND);
    }
    public static <T> ResponseEntity<ResponseContent<T>> _404(){
        return resourceNotFound();
    }

    public static <T> ResponseEntity<ResponseContent<T>> forbidden(){
        return create(new ResponseContent<>(HttpStatus.FORBIDDEN.value(),false,null,null), HttpStatus.FORBIDDEN);
    }
    public static <T> ResponseEntity<ResponseContent<T>> _403(){
        return forbidden();
    }

    public static <T> ResponseEntity<ResponseContent<T>> unAuthorized(){
        return create(new ResponseContent<>(HttpStatus.UNAUTHORIZED.value(),false,null,null), HttpStatus.UNAUTHORIZED);
    }
    public static <T> ResponseEntity<ResponseContent<T>> _401(){
        return unAuthorized();
    }



    public static <T> ResponseEntity<ResponseContent<T>> fail(HttpStatus status){
        return create(new ResponseContent<>(status.value(),false,null,null),status);
    }
    public static <T> ResponseEntity<ResponseContent<T>> fail(HttpStatus status, String message, T data){
        return create(new ResponseContent<>(status.value(),false,message,data), status);
    }

    public static <T> ResponseEntity<ResponseContent<T>> create(int code){
        return create(new ResponseContent<>(code,false,null,null),HttpStatus.OK);
    }
    public static <T> ResponseEntity<ResponseContent<T>> create(int code, HttpStatus status){
        return create(new ResponseContent<>(code,false,null,null),status);
    }
    public static <T> ResponseEntity<ResponseContent<T>> create(int code, String message, T data){
        return create(new ResponseContent<>(code,true,message,data), HttpStatus.OK);
    }
    public static <T> ResponseEntity<ResponseContent<T>> create(HttpStatus status, String message){
        return create(new ResponseContent<>(status.value(),false,message,null), status);
    }
    public static <T> ResponseEntity<ResponseContent<T>> create(int code, HttpStatus status, String message){
        return create(new ResponseContent<>(code,false,message,null), status);
    }
    public static <T> ResponseEntity<ResponseContent<T>> create(int code, HttpStatus status, String message, T data){
        return create(new ResponseContent<>(code,false,message,data), status);
    }
}
