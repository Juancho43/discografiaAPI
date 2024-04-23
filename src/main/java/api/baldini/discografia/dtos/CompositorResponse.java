package api.baldini.discografia.dtos;

import lombok.Data;

@Data
public class CompositorResponse {
    private long id;
    private String nombre;
    private String nacionalidad;
    private String descripcion;
}

