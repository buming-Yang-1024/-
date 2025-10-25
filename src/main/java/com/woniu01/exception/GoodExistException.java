package com.woniu01.exception;

/**
 * ClassName: GoodCategoryExistException
 * Package: com.woniu01.exception
 * Description:
 *
 * @Author: LZ
 * @Create: 2025/8/16 - 10:56
 * @Version: V1.0
 */
public class GoodExistException extends RuntimeException{
    public GoodExistException() {
    }

    public GoodExistException(String message) {
        super(message);
    }

    public GoodExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoodExistException(Throwable cause) {
        super(cause);
    }

    public GoodExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
