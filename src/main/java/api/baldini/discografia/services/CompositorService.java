package api.baldini.discografia.services;

import api.baldini.discografia.model.Compositor;
import api.baldini.discografia.repositories.ICompositorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CompositorService {
    @Autowired
    ICompositorRepository compositorRepository;

    public ArrayList<Compositor> getCompositores(){
        return (ArrayList<Compositor>) compositorRepository.findAll();
    }

    public Optional<Compositor> getById(Long id){
        return (Optional<Compositor> )compositorRepository.findById(id);
    }

    public Compositor saveCompositor(Compositor compositor){
        return compositorRepository.save(compositor);
    }

    public Compositor updateById(Compositor request, Long id){
        Compositor compositor = compositorRepository.findById(id).get();
        compositor.setNombre(request.getNombre());
        compositor.setDescripcion(request.getDescripcion());
        compositor.setNacionalidad(request.getNacionalidad());
        saveCompositor(compositor);
        return compositor;

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
