package se.ecutb.peter.Formbinding_practice_Create_Customer.dto;

import javax.validation.constraints.*;

public class CustomerDetailsFormDto {






    //INTE ANVÄNDA DENNA KLASS?!?!?!?!?!?!?!











    @NotBlank(message = "A unique detail Id is required.")
    @NotNull(message = "Detail Id cannot be null.")
    private String detailsId;

//    @NotBlank(message = "Street cannot be blank.")
    @NotNull(message = "Street cannot be null.")
    @Size(min=3, max=100, message = "Street name needs to be from 3 to 100 characters long.")
    private String street;

    @NotNull(message = "Zipcode cannot be null.")
    @Size(min=5, max=5, message = "Zipcode needs to be 5 digits long.")
    @Pattern(regexp = "[0-9]{5}", message = "A valid swedish zipcode is required.")
    private String zipCode;

    @NotNull(message = "City cannot be null.")
    @Size(min=3, max=100, message = "City needs to be from 3 to 100 characters long.")
    private String city;


    @NotNull(message = "Homephone number cannot be null.")
    @Pattern(regexp = "(\\+46|0)[0-9]{7}", message = "A valid swedish phone number is required.")
    private String homePhone;

    @NotNull(message = "A valid swedish cellphone number is required.")
    @Pattern(regexp = "(\\+46|0)[0-9]{9}", message = "A valid swedish phone number is required.")
    private String cellPhone;


    public String getDetailsId() {
        return detailsId;
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
