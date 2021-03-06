package igf.g6.adopcionesservice.resources;

import igf.g6.adopcionesservice.models.Adopcion;
import igf.g6.adopcionesservice.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class AdopcionController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AdopcionService adopcionService;

    @RequestMapping("/adopciones")
    public List<Adopcion> getAllAdopciones(){
        return adopcionService.getAllAdopciones();
    }

    @RequestMapping("/adopciones/{id}")
    public Adopcion getAdopcion(@PathVariable String id){
        return adopcionService.getAdopcion(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/adopciones")
    public void addAdopcion(@RequestBody Adopcion adopcion){
//        Persona madre =
//                restTemplate.getForObject("http://localhost:3001/nacimientos/");
        adopcionService.addAdopcion(adopcion);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value="/adopciones/{id}")
    public void updateAdopcion(@RequestBody Adopcion adopcion, @PathVariable String id){
        adopcionService.updateAdopcion(adopcion);
    }

    @RequestMapping(method =
            RequestMethod.DELETE, value =
            "/adopciones/{id}")
    public void deleteAdopcion(@PathVariable
                            String id){
        adopcionService.deleteAdopcion(id);
    }
}
