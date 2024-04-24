package api.baldini.discografia.mappers;

import api.baldini.discografia.dtos.DiscoResponse;
import api.baldini.discografia.dtos.DiscosResponse;
import api.baldini.discografia.model.Disco;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscoMapper {
    public DiscosResponse ListDiscosToDiscosResponse(List<Disco> discos){
        DiscosResponse c = new DiscosResponse();
        List<DiscoResponse> responseList = new ArrayList<>();
        for (Disco disco : discos) {
            responseList.add(DiscoToDiscoResponse(disco));
        }
        c.setDiscos(responseList);
        return  c;
    }
    public DiscoResponse DiscoToDiscoResponse(Disco disco){
        DiscoResponse response = new DiscoResponse();
        response.setTitulo(disco.getTitulo());
        response.setFechaPublicacion(disco.getFechaPublicacion());
        return response;
    }

}

