package com.spring.crud.Service;

import com.spring.crud.DTO.CustomerAddDTO;
import com.spring.crud.DTO.CustomerDTO;
import com.spring.crud.DTO.CustomerUpdateDTO;
import com.spring.crud.Entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public String addCustomer(CustomerAddDTO customerAddDTO);
    public List<CustomerDTO> getCustomers();
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO);
    public String deleteCustomer(long customerID);
}
