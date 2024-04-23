package api.baldini.discografia.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CancionRequest {
    private Long id;
    private List<CompositorRequest> compositores;
    private List<DiscoRequest> discos;
    private String titulo;
    private String duracion;
    private String genero;
}
