package api.baldini.discografia.controllers;

import api.baldini.discografia.model.Compositor;
import api.baldini.discografia.model.Disco;
import api.baldini.discografia.services.CompositorService;
import api.baldini.discografia.services.DiscoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ArrayList<Disco> getDiscos(){
        return this.discoService.getDiscos();
    }

    @PostMapping("/new")
    public Disco saveDisco(@RequestBody Disco disco){
        return this.discoService.saveDisco(disco);
    }
    @GetMapping("/{id}")
    public Optional<Disco> geyCompositorById(@PathVariable("id") Long id){
        return discoService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Disco updateDiscoById(@PathVariable("id") Long id, @RequestBody Disco request ){
        return discoService.updateById(request, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCompositorById(@PathVariable("id") Long id){
        boolean ok = discoService.deleteDiscoById(id);
        if (ok){
            return "Disco eliminado.";
        }else{
            return "Error";
        }
    }

}
