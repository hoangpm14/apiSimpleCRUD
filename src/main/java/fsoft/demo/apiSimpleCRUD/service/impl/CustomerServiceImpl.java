package fsoft.demo.apiSimpleCRUD.service.impl;

import fsoft.demo.apiSimpleCRUD.customExceptions.CustomerNotFoundException;
import fsoft.demo.apiSimpleCRUD.entity.Customer;
import fsoft.demo.apiSimpleCRUD.repository.CustomerRepository;
import fsoft.demo.apiSimpleCRUD.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomer()
    {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findCustomerById(Long id)
    {
//        Optional tra ve isPresent()=true neu customer != null
        Optional<Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent())
        {
            throw new CustomerNotFoundException(id);
        } else
        {
            return customer;
        }
    }

    @Override
    public ResponseEntity<Object> createCustomer(Customer customer)
    {
        Customer saveCustomer = customerRepository.save(customer);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(saveCustomer.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<Object> updateCustomer(Customer customer, long id)
    {
        return null;
    }

    @Override
    public void deleteCustomerById(long id)
    {

    }
}
