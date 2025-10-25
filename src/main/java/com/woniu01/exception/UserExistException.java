package com.woniu01.exception;

/**
 * ClassName: UserExistException
 * Package: com.woniu01.exception
 * Description:
 *
 * @Author: LZ
 * @Create: 2025/8/15 - 16:25
 * @Version: V1.0
 */
public class UserExistException extends RuntimeException{
    public UserExistException() {
    }

    public UserExistException(String message) {
        super(message);
    }

    public UserExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistException(Throwable cause) {
        super(cause);
    }

    public UserExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
