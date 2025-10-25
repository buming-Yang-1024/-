package com.woniu01.exception;

/**
 * ClassName: AddressNotExistException
 * Package: com.woniu01.exception
 * Description:
 *
 * @Author: LZ
 * @Create: 2025/8/16 - 17:28
 * @Version: V1.0
 */
public class AddressNotExistException extends RuntimeException{
    public AddressNotExistException() {
    }

    public AddressNotExistException(String message) {
        super(message);
    }

    public AddressNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressNotExistException(Throwable cause) {
        super(cause);
    }

    public AddressNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
