package se.ecutb.peter.Formbinding_practice_Create_Customer.dto;

import org.springframework.beans.factory.annotation.Required;
import se.ecutb.peter.Formbinding_practice_Create_Customer.CustomerDetails;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class CustomerFormDto {

    public static final String EMAIL_REGEX = "^(\\D)+(\\w)*((\\.(\\w)+)?)+@(\\D)+(\\w)*((\\.(\\D)+(\\w)*)+)?(\\.)[a-z]{2,}$";
    public static final String EMAIL_MESSAGE = "Specified email address is invalid.";


    @NotBlank(message = "Email is required.")
    @Email(regexp = EMAIL_REGEX, flags = Pattern.Flag.CASE_INSENSITIVE, message = EMAIL_MESSAGE)
    private String email;

    //@NotNull(message = NULL_REGDATE_MESSAGE)
    private LocalDate regDate = LocalDate.now();

    //@NotNull(message = "Active must be Yes or No.")
    private boolean active = true;

    //@NotNull(message = "Details cannot be null.")
    CustomerDetails details;

 //------------------------------------
 //CustomerDetails

    //denna behöver du inte för att skapa dton du VILL att den ska vara null Ok!
    //private String detailsId;


    private String street;
    private String zipCode;
    private String city;
    private String homePhone;

    //@NotNull(message = "A valid swedish cellphone number is required.")
    //@Pattern(regexp = CELLPHONE_REGEX, message = "A valid swedish cellphone number is required.")
    private String cellPhone;


//    public String getCustomerId() {
//        return customerId;
//    }


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



    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

}
