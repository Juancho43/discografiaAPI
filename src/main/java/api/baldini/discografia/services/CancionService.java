package api.baldini.discografia.services;

import api.baldini.discografia.model.Cancion;
import api.baldini.discografia.model.Disco;
import api.baldini.discografia.repositories.ICancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CancionService {
    @Autowired
    ICancionRepository cancionRepository;

    public ArrayList<Cancion> getCanciones(){
        return (ArrayList<Cancion>) cancionRepository.findAll();
    }

    public Optional<Cancion> getById(Long id){
        return (Optional<Cancion>) cancionRepository.findById(id);
    }

    public Cancion saveCancion(Cancion cancion){
        return cancionRepository.save(cancion);
    }

    public Cancion updateById(Cancion request, Long id){
        Cancion cancion = cancionRepository.findById(id).get();
        cancion.setTitulo(request.getTitulo());
        cancion.setGenero(request.getGenero());
        cancion.setDuracion(request.getDuracion());
        cancion.setDiscos(request.getDiscos());
        cancion.setCompositores(request.getCompositores());
        saveCancion(cancion);
        return cancion;

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
