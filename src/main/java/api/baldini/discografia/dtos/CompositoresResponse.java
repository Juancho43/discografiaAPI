package api.baldini.discografia.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CompositoresResponse {
    private List<CompositorResponse> compositores;
}
