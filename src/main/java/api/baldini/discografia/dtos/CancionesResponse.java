package api.baldini.discografia.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CancionesResponse {
    private List<CancionResponse> canciones;
}
