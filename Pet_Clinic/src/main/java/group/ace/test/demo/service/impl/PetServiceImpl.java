package group.ace.test.demo.service.impl;

import group.ace.test.demo.api.models.PetDTO;
import group.ace.test.demo.domain.Pet;
import group.ace.test.demo.repository.PetRepository;
import group.ace.test.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService {
    private PetRepository petRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public PetDTO createNewPet(PetDTO petDTO) {
//        Customer owner = new Customer();
//        owner.setAge(petDTO.getAge1());
//        owner.setName(petDTO.getName1());
//        owner.setSurname(petDTO.getSurname1());
        Pet pet = Pet.builder().petType(petDTO.getPetType()).age(petDTO.getAge())
                .name(petDTO.getName()).build();
        petRepository.save(pet);
        return petDTO;
    }

    @Override
    public void deleteAllPets() {
        petRepository.deleteAll();
    }
}
