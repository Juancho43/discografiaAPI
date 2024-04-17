package api.baldini.discografia.controllers;

import api.baldini.discografia.model.Cancion;
import api.baldini.discografia.model.Disco;
import api.baldini.discografia.services.CancionService;
import api.baldini.discografia.services.CompositorService;
import api.baldini.discografia.services.DiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/cancion")
public class CancionController {
    @Autowired
    private CancionService cancionService;

    @Autowired
    private DiscoService discoService;


    @GetMapping("/getAll")
    public ArrayList<Cancion> getCanciones(){
        return this.cancionService.getCanciones();
    }

    @PostMapping("/new")
    public Cancion saveCancion(@RequestBody Cancion cancion){
        return this.cancionService.saveCancion(cancion);
    }
    @GetMapping("{id}")
    public Optional<Cancion> getCancionById(@PathVariable("id") Long id){
        return cancionService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Cancion updateCancionById(@PathVariable("id") Long id, @RequestBody Cancion request ){
        return cancionService.updateById(request, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCancionById(@PathVariable("id") Long id){
        boolean ok = cancionService.deleteCancionById(id);
        if (ok){
            return "Cancion eliminada.";
        }else{
            return "Error";
        }
    }

}
