package se.ecutb.peter.Formbinding_practice_Create_Customer;

import java.util.Objects;
import java.util.UUID;

public class CustomerDetails {
    private String detailsId;
    private String street;
    private String zipCode;
    private String city;
    private String homePhone;
    private String cellPhone;

    public CustomerDetails(String street, String zipCode, String city, String homePhone, String cellPhone) {
        detailsId = UUID.randomUUID().toString();
        setStreet(street);  //Fixat anropa resten av setters i construktorn för att säkerställa.
        setZipCode(zipCode);
        setCity(city);
        setHomePhone(homePhone);
        setCellPhone(cellPhone);
    }

    public CustomerDetails(){}


    public String getDetailsId() {
        return detailsId;
    }


    public String getStreet() {
        return street;
    }


        public void setStreet(String street){       //Denna gör precis rätt. Detta är ingen form får den in null eller "" får den ett default värde
        if(street == null || street.isEmpty()){
            this.street = "No street defined";
        }
        else{
            this.street = street;
        }
    }



    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        if(zipCode == null || zipCode.isEmpty()){
            this.zipCode = "No zipcode defined";
        }
        else{
            this.zipCode = zipCode;
        }
    }



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if(city == null || city.isEmpty()){
            this.city = "No city defined";
        }
        else{
            this.city = city;
        }
    }


    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        if(homePhone == null || homePhone.isEmpty()){
            this.homePhone = "No homephone number defined";
        }
        else{
            this.homePhone = homePhone;
        }
    }



    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        if(cellPhone == null || cellPhone.isEmpty()){
            this.cellPhone = "No cellphone number defined";
        }
        else{
            this.cellPhone = cellPhone;
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDetails that = (CustomerDetails) o;
        return Objects.equals(detailsId, that.detailsId) &&
                Objects.equals(street, that.street) &&
                Objects.equals(zipCode, that.zipCode) &&
                Objects.equals(city, that.city) &&
                Objects.equals(homePhone, that.homePhone) &&
                Objects.equals(cellPhone, that.cellPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detailsId, street, zipCode, city, homePhone, cellPhone);
    }


    @Override
    public String toString() {
        return "CustomerDetails{" +
                "detailsId='" + detailsId + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                '}';
    }


}
