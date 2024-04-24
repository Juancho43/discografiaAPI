package api.baldini.discografia.controllers;

import api.baldini.discografia.dtos.DiscosResponse;
import api.baldini.discografia.model.Compositor;
import api.baldini.discografia.model.Disco;
import api.baldini.discografia.services.CompositorService;
import api.baldini.discografia.services.DiscoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/disco")
public class DiscoController {
    @Autowired
    private CompositorService compositorService;

    @Autowired
    private DiscoService discoService;
    @GetMapping("/getAll")
    public DiscosResponse getDiscos(){
        return discoService.getDiscos();
    }

    @PostMapping("/new")
    public ResponseEntity saveDisco(@RequestBody Disco disco){
        discoService.saveDisco(disco);
        return ResponseEntity.ok("Registro guardado");
    }
    @GetMapping("/{id}")
    public Optional<Disco> geyCompositorById(@PathVariable("id") Long id){
        return discoService.getById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDiscoById(@PathVariable("id") Long id, @RequestBody Disco request ){
        discoService.updateById(request, id);
        return ResponseEntity.ok("Registro actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCompositorById(@PathVariable("id") Long id){
        try {
            discoService.deleteDiscoById(id);
            return ResponseEntity.ok("Registro eliminado");
        }

        catch(Exception ex) {
            return ResponseEntity.badRequest().body("No se pudo eliminar el registro. ");
        }
    }

}
