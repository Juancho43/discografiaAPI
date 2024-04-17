package api.baldini.discografia.controllers;

import api.baldini.discografia.model.Compositor;
import api.baldini.discografia.services.CompositorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/compositor")
public class CompositorController {
    @Autowired
    private CompositorService compositorService;

    @GetMapping("/getAll")
    public ArrayList<Compositor> getCompositores(){
        return this.compositorService.getCompositores();
    }

    @PostMapping("/new")
    public Compositor saveCompositor(@RequestBody Compositor compositor){
        return this.compositorService.saveCompositor(compositor);
    }
    @GetMapping("/{id}")
    public Optional<Compositor> geyCompositorById(@PathVariable("id") Long id){
        return compositorService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Compositor updateCompositorById(@PathVariable("id") Long id, @RequestBody Compositor request ){
        return compositorService.updateById(request, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCompositorById(@PathVariable("id") Long id){
        boolean ok = compositorService.deleteCompositorById(id);
        if (ok){
            return "Compositor deleteed";
        }else{
            return "Error";
        }
    }

}
