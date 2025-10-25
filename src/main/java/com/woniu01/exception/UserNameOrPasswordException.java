package com.woniu01.exception;

/**
 * ClassName: UserNameOrPasswordException
 * Package: com.woniu01.exception
 * Description:
 *
 * @Author: LZ
 * @Create: 2025/8/15 - 16:51
 * @Version: V1.0
 */
public class UserNameOrPasswordException extends  RuntimeException{
    public UserNameOrPasswordException() {
    }

    public UserNameOrPasswordException(String message) {
        super(message);
    }

    public UserNameOrPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNameOrPasswordException(Throwable cause) {
        super(cause);
    }

    public UserNameOrPasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
