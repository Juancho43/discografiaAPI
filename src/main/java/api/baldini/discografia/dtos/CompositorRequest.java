package api.baldini.discografia.dtos;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CompositorRequest {
    private long id;
    private String nombre;
    private String nacionalidad;
    private String descripcion;
}

