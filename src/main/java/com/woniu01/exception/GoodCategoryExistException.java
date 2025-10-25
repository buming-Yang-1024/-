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
public class GoodCategoryExistException extends RuntimeException{
    public GoodCategoryExistException() {
    }

    public GoodCategoryExistException(String message) {
        super(message);
    }

    public GoodCategoryExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoodCategoryExistException(Throwable cause) {
        super(cause);
    }

    public GoodCategoryExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
