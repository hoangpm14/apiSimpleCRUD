package fsoft.demo.apiSimpleCRUD.service;

import fsoft.demo.apiSimpleCRUD.entity.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface CustomerService
{
    List<Customer> findAllCustomer();

    Optional<Customer> findCustomerById(@PathVariable Long id);

    ResponseEntity<Object> createCustomer(@RequestBody Customer customer);

    ResponseEntity<Object> updateCustomer(@RequestBody Customer customer, @PathVariable long id);

    void deleteCustomerById(@PathVariable long id);
}

