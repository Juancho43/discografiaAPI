package api.baldini.discografia.services;

import api.baldini.discografia.dtos.CompositoresResponse;
import api.baldini.discografia.mappers.CompositorMapper;
import api.baldini.discografia.model.Compositor;
import api.baldini.discografia.repositories.ICompositorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CompositorService {
    @Autowired
    ICompositorRepository compositorRepository;

    @Autowired
    CompositorMapper compositorMapper;

    public CompositoresResponse getCompositores(){
        return  compositorMapper.ListCompositoresToCompositorResponse(compositorRepository.findAll());
    }

    public Optional<Compositor> getById(Long id){
        return (Optional<Compositor> )compositorRepository.findById(id);
    }

    public ResponseEntity saveCompositor(Compositor compositor){
        compositorRepository.save(compositor);
        return ResponseEntity.ok("Registro guardado");
    }

    public ResponseEntity updateById(Compositor request, Long id){
        Compositor compositor = compositorRepository.findById(id).get();
        compositor.setNombre(request.getNombre());
        compositor.setDescripcion(request.getDescripcion());
        compositor.setNacionalidad(request.getNacionalidad());
        saveCompositor(compositor);
        return ResponseEntity.ok("Registro actualizado");
    }

    public boolean deleteCompositorById(Long id){
        try{
            compositorRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
