package bck.api.safiderp.core.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO<T> {
    private String message;  // Mensaje de la respuesta
    private String status;  // Estado de la respuesta (ej: "success", "error")
    private T data;         // Datos de la respuesta (genéricos)
}
