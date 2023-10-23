package com.spring.crud.ServiceImpl;

import com.spring.crud.DTO.CustomerAddDTO;
import com.spring.crud.DTO.CustomerDTO;
import com.spring.crud.DTO.CustomerUpdateDTO;
import com.spring.crud.Entity.Customer;
import com.spring.crud.Repo.CustomerRepo;
import com.spring.crud.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepo customerRepo;
    public String addCustomer(CustomerAddDTO customerAddDTO){

        Customer customer = new Customer(
                customerAddDTO.getName(),
                customerAddDTO.getEmail(),
                customerAddDTO.getMobile(),
                customerAddDTO.getAddress()
        );

        customerRepo.save(customer);
        return customer.getName();
    }

    @Override
    public List<CustomerDTO> getCustomers() {
        List<Customer> customers = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<CustomerDTO>();

        for(Customer cust:customers){
            CustomerDTO customerDTO = new CustomerDTO(
                    cust.getId(),
                    cust.getName(),
                    cust.getEmail(),
                    cust.getMobile(),
                    cust.getAddress()

            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {

        if(customerRepo.existsById(customerUpdateDTO.getId())){
            Customer customer = customerRepo.getById(customerUpdateDTO.getId());

            customer.setName(customerUpdateDTO.getName());
            customer.setEmail(customerUpdateDTO.getEmail());
            customer.setAddress(customerUpdateDTO.getAddress());
            customer.setMobile(customerUpdateDTO.getMobile());
            customerRepo.save(customer);
            return customerUpdateDTO.getId()+" Updated Successfully";
        }else{
            return "No record found...";
        }
    }

        public String deleteCustomer(long customerID){
        if(customerRepo.existsById(customerID)){
           Customer customer = customerRepo.getById(customerID);
            customerRepo.delete(customer);
            return "Customer "+customerID+" deleted successfully..";
        }else{
            return "Customer not found..";
        }
    }


}
