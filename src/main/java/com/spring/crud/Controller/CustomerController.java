package com.spring.crud.Controller;

import com.spring.crud.DTO.CustomerAddDTO;
import com.spring.crud.DTO.CustomerDTO;
import com.spring.crud.Entity.Customer;
import com.spring.crud.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.spring.crud.DTO.CustomerUpdateDTO;

@RestController
@RequestMapping(path = "/api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public String addCustomer(@RequestBody CustomerAddDTO customerAddDTO){
        return customerService.addCustomer(customerAddDTO);
    }

    @GetMapping(path = "/")
    public List<CustomerDTO> getCustomers(){
        return customerService.getCustomers();
    }

    @PostMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        return customerService.updateCustomer(customerUpdateDTO);
    }


    @DeleteMapping(path = "/delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int id){
        return customerService.deleteCustomer(id);
    }




}
