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
public class EmailExistException extends RuntimeException{
    public EmailExistException() {
    }

    public EmailExistException(String message) {
        super(message);
    }

    public EmailExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailExistException(Throwable cause) {
        super(cause);
    }

    public EmailExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
