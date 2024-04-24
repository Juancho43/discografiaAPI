package api.baldini.discografia.mappers;

import api.baldini.discografia.dtos.CompositorResponse;
import api.baldini.discografia.dtos.CompositoresResponse;
import api.baldini.discografia.dtos.DiscoResponse;
import api.baldini.discografia.dtos.DiscosResponse;
import api.baldini.discografia.model.Compositor;
import api.baldini.discografia.model.Disco;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompositorMapper {
    public CompositoresResponse ListCompositoresToCompositorResponse(List<Compositor> compositores){
        CompositoresResponse c = new CompositoresResponse();
        List<CompositorResponse> responseList = new ArrayList<>();
        for (Compositor compositor : compositores) {
            responseList.add(CompositorToCompositorResponse(compositor));
        }
        c.setCompositores(responseList);
        return  c;
    }
    public CompositorResponse CompositorToCompositorResponse(Compositor compositor){
        CompositorResponse response = new CompositorResponse();
        response.setNombre(compositor.getNombre());
        response.setDescripcion(compositor.getDescripcion());
        response.setNacionalidad(compositor.getNacionalidad());
        return response;
    }

}

