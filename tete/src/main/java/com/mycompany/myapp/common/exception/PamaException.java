package com.mycompany.myapp.common.exception;

public class PamaException extends RuntimeException {

    private static final long serialVersionUID = -1;

    private int httpCode;
    private String errorCode;
    private String[] messageArray;

    public PamaException(int httpCode, String errorCode) {
        super();
        this.errorCode = errorCode;
        this.httpCode = httpCode;
    }

     public PamaException(int httpCode, String errorCode, String[] messageArray) {
        super();
        this.errorCode = errorCode;
        this.httpCode = httpCode;
        this.messageArray = messageArray;
    }

    public PamaException(int httpCode, String errorCode, Throwable throwable) {
        super(throwable);
        this.errorCode = errorCode;
        this.httpCode = httpCode;
    }

    public PamaException(int httpCode, String errorCode, String[] messageArray, Throwable throwable) {
        super(throwable);
        this.errorCode = errorCode;
        this.httpCode = httpCode;
        this.messageArray = messageArray;
    }

    public PamaException(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.httpCode = 400;
        this.messageArray = new String[] {errorMessage};
    }

    public PamaException(final String errorCode, String[] messageArray) {
        super();
        this.errorCode = errorCode;
        this.httpCode = 400;
        this.messageArray = messageArray;
    }

    public PamaException(int httpCode, String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.httpCode = httpCode;
        this.messageArray = new String[] {errorMessage};
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String[] getMessageArray() {
        return messageArray;
    }

    public void setMessageArray(String[] messageArray) {
        this.messageArray = messageArray;
    }

}
