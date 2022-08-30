package group.ace.test.demo.controllers;

import group.ace.test.demo.api.models.PetDTO;
import group.ace.test.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {
    private PetService petService;

    @Autowired

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/api/v1/pets")
    public PetDTO createNewPet(@RequestBody PetDTO petDTO) {
        return petService.createNewPet(petDTO);
    }

    @DeleteMapping("/api/v1/pet/deleteall")
    public void deleteAllPets() {
        petService.deleteAllPets();

    }
}
