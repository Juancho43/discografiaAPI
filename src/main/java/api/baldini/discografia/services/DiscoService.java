package api.baldini.discografia.services;

import api.baldini.discografia.model.Compositor;
import api.baldini.discografia.model.Disco;
import api.baldini.discografia.repositories.ICompositorRepository;
import api.baldini.discografia.repositories.IDiscoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DiscoService {
    @Autowired
    IDiscoRepository discoRepository;


    public ArrayList<Disco> getDiscos(){
        return (ArrayList<Disco>) discoRepository.findAll();
    }

    public Optional<Disco> getById(Long id){
        return (Optional<Disco>) discoRepository.findById(id);
    }

    public Disco saveDisco(Disco disco){
        return discoRepository.save(disco);
    }

    public Disco updateById(Disco request, Long id){
        Disco disco = discoRepository.findById(id).get();
        disco.setTitulo(request.getTitulo());
        disco.setFechaPublicacion(request.getFechaPublicacion());

        saveDisco(disco);
        return disco;

    }

    public boolean deleteDiscoById(Long id){
        try{
            discoRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
