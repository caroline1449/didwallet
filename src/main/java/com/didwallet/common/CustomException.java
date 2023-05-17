package com.didwallet.common;

/**
 *
 * 自定义的业务异常类
 *
 * @author 俞静雯
 * @date 2023/2/25
 */
public class CustomException extends RuntimeException{
    public CustomException(String message) {
        super(message);
    }
}
