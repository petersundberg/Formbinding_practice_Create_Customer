package se.ecutb.peter.Formbinding_practice_Create_Customer;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Customer {
    private String customerId;
    private String email;
    private LocalDate regDate;
    private boolean active;
    CustomerDetails details;



    public Customer(String email, LocalDate regDate, boolean active, CustomerDetails details) {
        customerId = UUID.randomUUID().toString(); //Här får den ju ett id - BRA (tack! :o))
        this.email = email;
        this.regDate = LocalDate.now();
        this.active = active;
        this.details = details;
    }

    public Customer(){}

    public String getCustomerId() {
        return customerId;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {

        this.email = email;
    }

    public LocalDate getRegDate() {
        return regDate;
    }
    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public CustomerDetails getDetails() {
        return details;
    }
    public void setDetails(CustomerDetails details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return active == customer.active &&
                Objects.equals(customerId, customer.customerId) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(regDate, customer.regDate) &&
                Objects.equals(details, customer.details);
    }


    @Override
    public int hashCode() {
        return Objects.hash(customerId, email, regDate, active, details);
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", email='" + email + '\'' +
                ", regDate=" + regDate +
                ", active=" + active +
                ", details=" + details +
                '}';
    }

}
