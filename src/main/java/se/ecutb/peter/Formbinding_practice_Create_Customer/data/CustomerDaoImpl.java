package se.ecutb.peter.Formbinding_practice_Create_Customer.data;

import org.springframework.stereotype.Component;
import se.ecutb.peter.Formbinding_practice_Create_Customer.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerDaoImpl implements CustomerDao {

    private List<Customer> customerList = new ArrayList<>();

    @Override
    public Customer save(final Customer customer) {
        if(customerList.contains(customer)){
            throw new IllegalArgumentException();
        }
        customerList.add((customer));
        return findById(customer.getCustomerId()).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Optional<Customer> findById(String customerId) {
        return customerList.stream()
                .filter(customer -> customer.getCustomerId().equals(customerId))
                .findFirst();
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return customerList.stream()
                .filter(customer -> customer.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    public List<Customer> findAll() {
        return Collections.unmodifiableList(customerList);
    }

    @Override
    public boolean delete(String customerId) {
        Optional<Customer> optional= findById(customerId);
        if(optional.isPresent()){
            return customerList.remove(optional.get());
        }
        return false;
    }

    @Override
    public Customer update(final Customer updatedCustomer) {
        Customer original = findById(updatedCustomer.getCustomerId()).orElseThrow(IllegalArgumentException::new);
        original.setEmail(updatedCustomer.getEmail());
        original.setActive(true);
        //original.setRegDate(updatedCustomer.getRegDate());
        original.setDetails(updatedCustomer.getDetails());
        return original;
    }

}





















