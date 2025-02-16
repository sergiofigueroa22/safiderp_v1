package bck.api.safiderp.core.exception;

public class GenericException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String errorCode;
    private final String errorMessage;

    public GenericException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}