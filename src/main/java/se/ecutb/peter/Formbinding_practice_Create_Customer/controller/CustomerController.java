package se.ecutb.peter.Formbinding_practice_Create_Customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import se.ecutb.peter.Formbinding_practice_Create_Customer.Customer;
import se.ecutb.peter.Formbinding_practice_Create_Customer.CustomerDetails;
import se.ecutb.peter.Formbinding_practice_Create_Customer.data.CustomerDao;
import se.ecutb.peter.Formbinding_practice_Create_Customer.dto.CustomerFormDto;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@Controller
public class CustomerController {

    private CustomerDao customerDao;

    @Autowired
    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @GetMapping("customer/create")
    public ModelAndView getForm(){
        CustomerFormDto customerDto = new CustomerFormDto();
        ModelAndView model = new ModelAndView();
        model.addObject("form", customerDto);
        model.setViewName("customer");
        return model;
    }

    @PostMapping("customer/process")
    public String processForm(@Valid @ModelAttribute("form") CustomerFormDto customerDto, BindingResult bindingResult){

        if(customerDao.findByEmail(customerDto.getEmail()).isPresent()){
            FieldError emailError = new FieldError("form", "email", customerDto.getEmail() + " is already in use.");
            bindingResult.addError(emailError);
        }
        if(bindingResult.hasErrors()){
            return "customer";
        }
        Customer newCustomer =new Customer(customerDto.getEmail(), customerDto.getRegDate(), customerDto.isActive(), new CustomerDetails(
            customerDto.getEmail(),
            customerDto.getStreet(),
            customerDto.getCity(),
            customerDto.getHomePhone(),
            customerDto.getCellPhone()
            ));

        newCustomer = customerDao.save(newCustomer);
        return "redirect:/customer?type=id&value=" + newCustomer.getCustomerId();
    }

    //Du har ingen controller metod som tar dig till customerSearch
    @GetMapping("customer/search")
    public String getSearch(){

        return "customerSearch";
    }

//    @GetMapping("/customer/email")
//    public String findByEmail(Model model, String email){
//        model.addAttribute("customers", customerDao.findByEmail(email));
//        return "customerView";
//    }


    @GetMapping("customer/view")
    public String showSearch(){
        return "customerView";
    }

    @GetMapping("/customer")
    public String find(@RequestParam("type") String type, @RequestParam("value") String value, Model model){

        Optional<Customer> optionalCustomer = Optional.empty();
        switch(type){
            case "id":
                optionalCustomer = customerDao.findById(value);
                break;
            case "email":
                optionalCustomer = customerDao.findAll().stream()
                        .filter(customer -> customer.getEmail().equalsIgnoreCase(value))
                        .findFirst();
                break;
            default:
                throw new IllegalArgumentException("Type " + type + " is unknown.");
        }

        if(optionalCustomer.isPresent()){
            model.addAttribute("customer", optionalCustomer.get());
        }
        else{
            model.addAttribute("message", "Customer was not found.");
        }

        return "customerView";

    }



//            return "customerSearch";    //Aha :) :(   :) som jag sagt tidigare, jag har SÅ svårt för att se gången i det hela, att fälja vad som händer och HUR.
//    // Man måste ju för visa formuläret innan man kan använda det. Givetvis, när du säger det :). Tips: I projektet jobba inte själv
//    //funderade på det också ska höra om någon vill jobba med mig, vet inte vem än ... Jag ser dig som en av de bästa eleverna (PÅ RIKTIGT!)
//    //Nä, Eerik. Nu får du skärpa dig! :o) men TACK SOM F A N!  TÖdmyYUVärr känner jag  mig INTE sån. Ödmjukhet är bra. Men sedan avancerad javaprogrammering har du varit MYCKET bra
//    //Tack! Ska FÖRSÖKA tänka så ... Jag har ett "talesätt" som jag kommit på och som jag kör med : " Ödmjukhet är min enda last"! ;o) Jag gillar att du frågar mycket
//    //å jag som bara känner mig okunnig och jobbig när jag frågar dig hela tiden" Robin delar min uppfattning om dig
//    //Oj, väldigt ul att höra! Åter till mina frågor ...?ok
//}


//        Customer newCustomer =new Customer(customerDto.getEmail(), LocalDate.now(), customerDto.isActive(), customerDto.getDetails());
//        newCustomer = customerDao.save(newCustomer);

//    @GetMapping("/customer")
//    public String findAll(Model model){
//        model.addAttribute("customers", customerDao.findAll());
//        return "customer-view"; //return "customer-list";
//    }


//    @GetMapping("users")
//    public String find(@RequestParam("type") String type, @RequestParam("value") String value, Model model){
//        Optional<AppUser> optionalAppUser = Optional.empty();
//
//        switch (type){
//            case "id":
//                optionalAppUser = appUserDao.findById(value);
//                break;
//            case "email":
//                optionalAppUser = appUserDao.findAll().stream()
//                        .filter(user -> user.getEmail().equalsIgnoreCase(value))
//                        .findFirst();
//                break;
//            default:
//                throw new IllegalArgumentException("Type " + type + "is unknown");
//        }
//
//        if(optionalAppUser.isPresent()){
//            model.addAttribute("user", optionalAppUser.get());
//        }else {
//            model.addAttribute("message", "User could not be found");
//        }
//
//
//        return "user-view";
//    }













//    @PostMapping("users/process")
//    public String processForm(@Valid @ModelAttribute("form") AppUserFormDto formDto, BindingResult bindingResult){
//
//        if(appUserDao.findByEmail(formDto.getEmail()).isPresent()){
//            FieldError emailError = new FieldError("form","email","Email " + formDto.getEmail() +" is already defined");
//            bindingResult.addError(emailError);
//        }
//
//        if(!formDto.getPassword().equals(formDto.getPasswordConfirm())){
//            FieldError confirmError = new FieldError("form", "passwordConfirm", "Your password confirmation didn't match the password");
//            bindingResult.addError(confirmError);
//        }
//
//        if(bindingResult.hasErrors()){
//            return "create-user";
//        }
//
//        AppUser newAppUser = new AppUser(formDto.getEmail(), formDto.getFirstName(), formDto.getLastName(), formDto.getPassword());
//        newAppUser = appUserDao.save(newAppUser);
//
//        return "redirect:/users?type=id&value="+newAppUser.getUserId();
//    }




//    @GetMapping("users/create")
//    public ModelAndView getForm(){
//        AppUserFormDto formDto = new AppUserFormDto();
//        ModelAndView model = new ModelAndView();
//        model.addObject("form", formDto);
//        model.setViewName("create-user");
//        //model.addAttribute("form", formDto);
//        return model;
//    }







}














