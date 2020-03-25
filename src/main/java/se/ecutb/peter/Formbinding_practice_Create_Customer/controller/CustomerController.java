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



    @GetMapping("customer/view")
    public String showView(){
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


}















