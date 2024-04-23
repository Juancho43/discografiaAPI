package api.baldini.discografia.dtos;

import lombok.Data;

import java.util.List;

@Data
public class DiscosResponse {
    private List<DiscoResponse> discos;
}
