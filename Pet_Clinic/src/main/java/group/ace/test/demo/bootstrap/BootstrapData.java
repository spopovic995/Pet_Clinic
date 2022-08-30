package group.ace.test.demo.bootstrap;

import group.ace.test.demo.domain.*;
import group.ace.test.demo.repository.CustomerRepository;
import group.ace.test.demo.repository.PetRepository;
import group.ace.test.demo.repository.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;
//Iskomentiran mi e COMPONENT, zatoa ne inicijalizira !!!
//@Component
public class BootstrapData {
    private final PetRepository petRepository;
    private final CustomerRepository customerRepository;
    private final VetRepository vetRepository;

    @Autowired
    public BootstrapData(PetRepository petRepository, CustomerRepository customerRepository, VetRepository vetRepository) {
        this.petRepository = petRepository;
        this.customerRepository = customerRepository;
        this.vetRepository = vetRepository;
    }

    @PostConstruct
    public void run() {
        initializeVets();
        initializeCustomers();
        initializePets();

    }

    private void initializePets() {
        Pet pet = Pet.builder()
                .age("5")
                .name("milica")
                .petType(PetType.CAT)
                .build();
        Customer customer = customerRepository.findByName("Marija").get();
        customer.getPets().add(pet);
        pet.setOwner(customer);
        petRepository.save(pet);
        customerRepository.save(customer);

    }

    private void initializeCustomers() {
        Contact contact = new Contact();
        contact.setAddress("sdfgsd");
        contact.setEmail("sfefsfse@dsfs");
        contact.setTelephone("34534534534");
        Customer customer = Customer.builder()
                .name("Marija")
                .age(85)
                .contact(contact)
                .build();
        customerRepository.save(customer);

        Contact contact1 = Contact.builder().address("dsadas")
                .email("sdas@dasd").secondaryEmail("dsads@adsd")
                .telephone("233").build();
        Pet p = Pet.builder().petType(PetType.DOG).age("3").name("milicaaa")
                .build();
        Pet k = Pet.builder().petType(PetType.DOG).age("7").name("mesi")
                .build();
        Set<Pet> pets = new HashSet<>();
        pets.add(p);
        pets.add(k);
        Customer customer2 = Customer.builder().age(23).name("Saljoto")
                .surname("popovic").pets(pets).contact(contact1).build();
        p.setOwner(customer2);
        k.setOwner(customer2);
        customerRepository.save(customer2);
        petRepository.save(p);
        petRepository.save(k);

    }

    private void initializeVets() {
        Contact contact = new Contact();
        contact.setAddress("radisani");
        contact.setEmail("sdaasfaZ@dsfs");
        contact.setTelephone("5496456");
        Vet vet = Vet.builder()
                .age(25)
                .name("saljo")
                .surname("sdfsd")
                .contact(contact)
                .build();
        vetRepository.save(vet);

        Contact contact1 = new Contact();
        contact.setAddress("Aerodrom");
        contact.setEmail("sdaasfaZ@dsfs");
        contact.setTelephone("3424");
        Vet vet1 = Vet.builder()
                .age(25)
                .name("Ace")
                .surname("sdfsd")
                .contact(contact1)
                .build();
        vetRepository.save(vet1);

    }

}
