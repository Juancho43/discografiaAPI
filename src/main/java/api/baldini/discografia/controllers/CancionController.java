package api.baldini.discografia.controllers;

import api.baldini.discografia.dtos.CancionResponse;
import api.baldini.discografia.dtos.CancionesResponse;
import api.baldini.discografia.model.Cancion;
import api.baldini.discografia.model.Disco;
import api.baldini.discografia.services.CancionService;
import api.baldini.discografia.services.CompositorService;
import api.baldini.discografia.services.DiscoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/cancion")
public class CancionController {
    @Autowired
    private CancionService cancionService;

    @GetMapping("/getAll")
    public CancionesResponse getCanciones(){
        return cancionService.getCanciones();
    }

    @PostMapping("/new")
    public ResponseEntity saveCancion(@RequestBody Cancion cancion){
        return this.cancionService.saveCancion(cancion);
    }
    @GetMapping("{id}")
    public Optional<Cancion> getCancionById(@PathVariable("id") Long id){
        return cancionService.getById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCancionById(@PathVariable("id") Long id, @RequestBody Cancion request ){
        return cancionService.updateById(request, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCancionById(@PathVariable("id") Long id){
        boolean ok = cancionService.deleteCancionById(id);
        if (ok){
            return ResponseEntity.ok("Registro eliminado");
        }else{
            return ResponseEntity.badRequest().body("No se pudo eliminar el registro.");
        }
    }

}
