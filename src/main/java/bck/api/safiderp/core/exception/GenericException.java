package bck.api.safiderp.core.exception;

import org.springframework.dao.DataAccessException;

import lombok.Getter;

@Getter
public class GenericException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String errorCode;
    private final String errorMessage;
    

    public GenericException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }


    public GenericException(String errorCode, String errorMessage, DataAccessException ex) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}