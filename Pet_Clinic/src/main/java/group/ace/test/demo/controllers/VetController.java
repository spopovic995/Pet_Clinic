package group.ace.test.demo.controllers;

import group.ace.test.demo.api.models.VetDTO;
import group.ace.test.demo.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(VetController.BASE_URL)
@RestController
public class VetController {

    private final VetService vetService;
    public static final String BASE_URL = "/api/v1/vets";

    @Autowired
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @PostMapping
    public VetDTO createNewVet(@RequestBody VetDTO vetDTO) {
        return vetService.createNewVet(vetDTO);
    }
//    @GetMapping("/{vetId}")
//    public VetDTO findById(@PathVariable Long vetId){
//        return vetService.findById(vetId);
//    }


}
