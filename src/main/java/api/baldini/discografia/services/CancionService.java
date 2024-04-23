package api.baldini.discografia.services;

import api.baldini.discografia.dtos.CancionResponse;
import api.baldini.discografia.dtos.CancionesResponse;
import api.baldini.discografia.mappers.CancionMapper;
import api.baldini.discografia.model.Cancion;
import api.baldini.discografia.model.Disco;
import api.baldini.discografia.repositories.ICancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CancionService {
    @Autowired
    ICancionRepository cancionRepository;

    @Autowired
    CancionMapper cancionMapper;
    public CancionesResponse getCanciones(){
        return cancionMapper.ListCancionesToCancionesResponse(cancionRepository.findAll());
    }

    public Optional<Cancion> getById(Long id){
        return (Optional<Cancion>) cancionRepository.findById(id);
    }

    public ResponseEntity saveCancion(Cancion cancion){
        cancionRepository.save(cancion);
        return ResponseEntity.ok("Registro guardado");
    }

    public ResponseEntity updateById(Cancion request, Long id){
        Cancion cancion = cancionRepository.findById(id).get();
        cancion.setTitulo(request.getTitulo());
        cancion.setGenero(request.getGenero());
        cancion.setDuracion(request.getDuracion());
        cancion.setDiscos(request.getDiscos());
        cancion.setCompositores(request.getCompositores());
        saveCancion(cancion);
        return ResponseEntity.ok("Registro actualizado");

    }

    public boolean deleteCancionById(Long id){
        try{
            cancionRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
