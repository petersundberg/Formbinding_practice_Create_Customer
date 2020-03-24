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
   /*
   Det finns en massa bortkommenterad kod här just nu, bortse från det ... :o)
   Jag tycker det här är VÄLDIGT svårt, därför undrar jag: SOm sagt, jag tycker detta är SÅ svårt ... fasar för projektet ...

1)    html-sida customerSearch laddas inte; "Whitelabel error page" ?

    ------------------------------------
2)   Enligt beskrivningen ska en del fält "not be null". Räcker det med att ha If-villkor i metoden för att förhindra att värdet är null?
   (Se metoder i class CustomerDetails)

   Exempel: If( field == null || field.isEmpty ...
            this.field = "Not defined"
            Else
            this.field = field;

     ... eller ska det valideras med @NotNull

    ------------------------------------
3)    detailsId ska vara "required", förstår inte  hur jag gör det ... Med @NotBlank  i aha, "bara" så @NotBlank får inte vara null ELLER tom. ok tack

    ------------------------------------
    frågan ang. validering av fält som ska kunna lämnas oifyllda:
    Detta faller utanför uppgiften. DU skulle kunna skapa regex som acceptera tom ELLER enlgit en viss mall. ok
    Så jag "ska" bara lämna de fälten som ska kunna lämnas oifyllda helt utan validering? så här ...ja. ok
4)    Hur validerar jag t.ex. Street, zipCode, City m.fl. om de samtidigt ska kunna lämnas tomma (Optional) och i så fall få ett String-värde?
      t.ex. Street; om jag INTE skriver validering godkänns ALLT, men om jag SKRIVER validering kan den INTE ta texten för om den lämnas tom?!
    ------------------------------------
5)    Är projektet färdigt om detta fixas?
        kanske är svårt att se för dig eftersom det är väldigt rörigt nu :) Städa upp lite. Jag tror du är färdig
        Ok, tack Erik. Dock misstänker jag att jag manske har yterligare frågor framöver ... men det går ju bra säger du?! ;o)japp

        Tusen tack för hjälpen!ingen fara
        jag ska kolla på detta och återkommer eventuellt eller skickar in uppgiften /Peter




    */




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







    //--------------------------------------------------
//    public String getCustomerId() {
//        return customerId;
//    }
//
//
//    public String getEmail() {
//        return email;
//    }
////    public void setEmail(String email) {
////        this.email = email;
////    }
//
////    public void setEmail(String email){
////        if(email == null || email.isEmpty()){
////            this.email = "Not defined";
////        }
////        else{
////            this.email = email;
////        }
////    }
//
//    public void setEmail(String email){
//        if(email == null || email.isEmpty()) {
//            this.email = "Email is empty and/or not in a valid format.";  //new IllegalArgumentException();
//        } else
//            {
//            this.email = email;
//        }
//    }
//
//
//    public LocalDate getRegDate() {
//        return regDate;
//    }
//
//    public void setRegDate(LocalDate regDate) {
////        if (regDate == null) {
////            throw new IllegalArgumentException();
////        }
//        this.regDate = LocalDate.now();
//    }
//
//
//    public boolean isActive() {
//        return active;
//    }
//
//    public void setActive(boolean active) {
////        if((active == false)){
////            this.active = false;
////        }
//        this.active = true;
//    }
//
//
//    public CustomerDetails getDetails() {
//        return details;
//    }
//
//    public void setDetails(CustomerDetails details) {
//        if(details == null){
//            throw new IllegalArgumentException();
//        }
//        details.setStreet(details.getStreet());
//        details.setZipCode(details.getZipCode());
//        details.setCity(details.getCity());
//        details.setHomePhone(details.getHomePhone());
//        details.setCellPhone(details.getCellPhone());
//        this.details = details;
//    }
//
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Customer customer = (Customer) o;
//        return active == customer.active &&
//                Objects.equals(customerId, customer.customerId) &&
//                Objects.equals(email, customer.email) &&
//                Objects.equals(regDate, customer.regDate) &&
//                Objects.equals(details, customer.details);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(customerId, email, regDate, active, details);
//    }
//
//    @Override
//    public String toString() {
//        return "Customer{" +
//                "customerId='" + customerId + '\'' +
//                ", email='" + email + '\'' +
//                ", regDate=" + regDate +
//                ", active=" + active +
//                ", details=" + details +
//                '}';
//    }
//--------------------------------------------------



}
