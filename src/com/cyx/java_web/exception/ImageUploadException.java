package com.cyx.java_web.exception;

public class ImageUploadException extends RuntimeException {
    private static final long serialVersionUID = -8273091235869746171L;

    public ImageUploadException(String message) {
        super(message);
    }

    public ImageUploadException(String message, Throwable cause) {
        super(message, cause);
    }
}
