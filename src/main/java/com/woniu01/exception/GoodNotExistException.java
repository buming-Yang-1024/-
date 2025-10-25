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
public class GoodNotExistException extends RuntimeException{
    public GoodNotExistException() {
    }

    public GoodNotExistException(String message) {
        super(message);
    }

    public GoodNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoodNotExistException(Throwable cause) {
        super(cause);
    }

    public GoodNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
