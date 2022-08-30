package group.ace.test.demo.service.impl;

import group.ace.test.demo.api.models.VetDTO;
import group.ace.test.demo.domain.Contact;
import group.ace.test.demo.domain.Vet;
import group.ace.test.demo.repository.VetRepository;
import group.ace.test.demo.service.VetService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VetServiceImpl implements VetService {

    private final VetRepository vetRepository;

    @Autowired
    public VetServiceImpl(VetRepository vetRepository) {
        this.vetRepository = vetRepository;

    }
    @Override
    public VetDTO createNewVet(VetDTO vetDTO) {
        Contact contact = new Contact();
        if (vetDTO.getEmail() == null || vetDTO.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        contact.setEmail(vetDTO.getEmail());

        contact.setSecondaryEmail(vetDTO.getSecondaryEmail());
        if (StringUtils.isBlank(vetDTO.getAddress())) {
            throw new IllegalArgumentException();
        }
        contact.setAddress(vetDTO.getAddress());
        if (StringUtils.isBlank(vetDTO.getTelephone())) {
            throw new IllegalArgumentException();
        }
        contact.setTelephone(vetDTO.getTelephone());
        if (vetDTO.getName() == null || vetDTO.getName().isBlank()){
            throw new IllegalArgumentException();
        }

        Vet vet = new Vet();
        vet.setContact(contact);
        if (vetDTO.getName().isEmpty() || vetDTO.getName().trim().isBlank()){
            throw new IllegalArgumentException();
        }
        vet.setName(vetDTO.getName());

        if (vetDTO.getSurname().isEmpty() || vetDTO.getSurname().trim().isBlank()){
            throw new IllegalArgumentException();
        }
        vet.setSurname(vetDTO.getSurname());

        if (vetDTO.getAge() == null){
            throw new IllegalArgumentException();
        }
        vet.setAge(vetDTO.getAge());

        vetRepository.save(vet);

        return vetDTO;

    }

//    @Override
//    public VetDTO findById(Long vetId) {
//        Vet vet = vetRepository.findById(vetId).get();
//
//    }
}
