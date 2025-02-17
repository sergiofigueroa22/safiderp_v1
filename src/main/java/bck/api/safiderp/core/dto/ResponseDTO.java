package bck.api.safiderp.core.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO<T> {
    private String message;
    private String status;
    private T data;
}
