package group.ace.test.demo.service.impl;

import group.ace.test.demo.api.mappers.CustomerMapper;
import group.ace.test.demo.api.models.CustomerDTO;
import group.ace.test.demo.domain.Contact;
import group.ace.test.demo.domain.Customer;
import group.ace.test.demo.repository.CustomerRepository;
import group.ace.test.demo.service.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
        Contact contact = new Contact();
        if (customerDTO.getEmail() == null || customerDTO.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        contact.setEmail(customerDTO.getEmail());

        contact.setSecondaryEmail(customerDTO.getSecondaryEmail());
        if (StringUtils.isBlank(customerDTO.getAddress())) {
            throw new IllegalArgumentException();
        }
        contact.setAddress(customerDTO.getAddress());
        if (StringUtils.isBlank(customerDTO.getTelephone())) {
            throw new IllegalArgumentException();
        }
        contact.setTelephone(customerDTO.getTelephone());
        Customer customer = new Customer();
        customer.setContact(contact);
        if (StringUtils.isBlank(customerDTO.getName())) {
            throw new IllegalArgumentException();
        }
        customer.setName(customerDTO.getName());
        if (StringUtils.isBlank(customerDTO.getSurname())) {
            throw new IllegalArgumentException();
        }
        customer.setSurname(customerDTO.getSurname());
        if ((customerDTO.getAge() < 18)) {
            throw new IllegalArgumentException();
        }
        customer.setAge(customerDTO.getAge());
        return customerMapper.customerToCustomerDTO(customerRepository.save(customer));
    }

    @Override
    public List<String> findAllByName() {
        return customerRepository.findAllByName();
    }

    @Override
    public Long deleteById(Long id) {
        customerRepository.deleteById(id);
        return id;
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO, Long id) throws Exception {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isEmpty()) {
            throw new Exception("there is no such customer with id = " + id);
        }
        Customer customer = optionalCustomer.get();
        customer.setAge(customerDTO.getAge());
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        return customerMapper.customerToCustomerDTO(customerRepository.save(customer));
    }
}
