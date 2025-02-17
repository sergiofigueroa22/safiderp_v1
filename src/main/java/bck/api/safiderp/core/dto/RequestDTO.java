package bck.api.safiderp.core.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDTO<T> {
    private T data;
}