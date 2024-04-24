package api.baldini.discografia.controllers;

import api.baldini.discografia.dtos.CompositoresResponse;
import api.baldini.discografia.model.Compositor;
import api.baldini.discografia.services.CompositorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/compositor")
public class CompositorController {
    @Autowired
    private CompositorService compositorService;

    @GetMapping("/getAll")
    public CompositoresResponse getCompositores(){
        return compositorService.getCompositores();
    }

    @PostMapping("/new")
    public ResponseEntity saveCompositor(@RequestBody Compositor compositor){
        return compositorService.saveCompositor(compositor);
    }
    @GetMapping("/{id}")
    public Optional<Compositor> geyCompositorById(@PathVariable("id") Long id){
        return compositorService.getById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCompositorById(@PathVariable("id") Long id, @RequestBody Compositor request ){
        return compositorService.updateById(request, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCompositorById(@PathVariable("id") Long id){


        try {
            compositorService.deleteCompositorById(id);
            return ResponseEntity.ok("Registro eliminado");
        }

        catch(Exception ex) {
            return ResponseEntity.badRequest().body("No se pudo eliminar el registro. El error es: " + ex.getMessage());
        }
        }
    }


