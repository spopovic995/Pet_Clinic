package group.ace.test.demo.service;

import group.ace.test.demo.api.models.PetDTO;

public interface PetService {
    PetDTO createNewPet(PetDTO petDTO);

    public void deleteAllPets();
}
