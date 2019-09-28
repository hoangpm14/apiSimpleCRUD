package fsoft.demo.apiSimpleCRUD.repository;

import fsoft.demo.apiSimpleCRUD.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>
{
}
