package tech.guyi.web.quick.core.exception;

public class NoAuthorizationException extends RuntimeException {

    public NoAuthorizationException(){
        super("请先登录");
    }

}
