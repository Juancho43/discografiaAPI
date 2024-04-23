package api.baldini.discografia.mappers;

import api.baldini.discografia.dtos.CancionResponse;
import api.baldini.discografia.dtos.CancionesResponse;
import api.baldini.discografia.model.Cancion;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CancionMapper {
    public CancionesResponse ListCancionesToCancionesResponse(List<Cancion> canciones){
        CancionesResponse c = new CancionesResponse();
        List<CancionResponse> cancionResponseList = new ArrayList<>();
        for (Cancion cancion:canciones) {

            cancionResponseList.add(CancionToCancionResponse(cancion));
        }
        c.setCanciones(cancionResponseList);
        return  c;
    }
    public CancionResponse CancionToCancionResponse(Cancion cancion){
        CancionResponse cancionResponse = new CancionResponse();
        cancionResponse.setTitulo(cancion.getTitulo());
        cancionResponse.setGenero(cancion.getGenero());
        cancionResponse.setDuracion(cancion.getDuracion());
        return  cancionResponse;
    }

}

