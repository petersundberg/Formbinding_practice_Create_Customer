package se.ecutb.peter.Formbinding_practice_Create_Customer.data;

import se.ecutb.peter.Formbinding_practice_Create_Customer.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {

    Customer save(Customer customer);
    Optional<Customer> findById(String customerId);
    Optional<Customer> findByEmail(String email);
    List<Customer> findAll();
    boolean delete(String customerId);
    Customer update(Customer updatedCustomer);


}
