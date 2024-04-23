package api.baldini.discografia.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CancionResponse {
    private Long id;
    private List<CompositorResponse> compositores;
    private List<DiscoResponse> discos;
    private String titulo;
    private String duracion;
    private String genero;
}
