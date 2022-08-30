package group.ace.test.demo.service;

import group.ace.test.demo.api.models.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO createNewCustomer(CustomerDTO customerDTO);

    public List<String> findAllByName();

    public Long deleteById(Long id);

    CustomerDTO updateCustomer(CustomerDTO customerDTO, Long id) throws Exception;
}


