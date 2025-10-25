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
public class GoodCategoryNotExistException extends RuntimeException{
    public GoodCategoryNotExistException() {
    }

    public GoodCategoryNotExistException(String message) {
        super(message);
    }

    public GoodCategoryNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoodCategoryNotExistException(Throwable cause) {
        super(cause);
    }

    public GoodCategoryNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
