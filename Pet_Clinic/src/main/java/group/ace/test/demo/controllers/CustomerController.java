package group.ace.test.demo.controllers;

import group.ace.test.demo.api.models.CustomerDTO;
import group.ace.test.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    private static final String BASE_URL = "/api/v1/customers";

    @PostMapping(value = "/api/v1/customers")
    public CustomerDTO createNewCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.createNewCustomer(customerDTO);
    }

    @GetMapping(value = "/api/v1/customers/list")
    public ArrayList<String> findAllCustomers() {
        return (ArrayList<String>) customerService.findAllByName();
    }

    @DeleteMapping(value = "api/v1/customers/{id}")
    public Long deleteCustomer(@PathVariable("id") Long id) {
        return customerService.deleteById(id);
    }

    @PutMapping(value = "/api/v1/customers/{id}")
    public CustomerDTO updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerDTO customerDTO) throws Exception {
        return customerService.updateCustomer(customerDTO, id);
    }
}
