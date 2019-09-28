package fsoft.demo.apiSimpleCRUD.controller;

import fsoft.demo.apiSimpleCRUD.entity.Customer;
import fsoft.demo.apiSimpleCRUD.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

//    ========  Create a Customer    ========
    @PostMapping("/customers")
    public ResponseEntity<Object> createStudent(@RequestBody Customer customer)
    {
        return customerService.createCustomer(customer);
    }

//    ========  Retrieve All Customers    ========
    @GetMapping("/customers")
    public List<Customer> retrieveAllCustomers()
    {
        return customerService.findAllCustomer();
    }

//    ========  Retrieve Customer by Id    ========
    @GetMapping("/customers/{id}")
    public Customer retrieveCustomerById(Long id)
    {
        return customerService.findCustomerById(id).get();
    }
}
