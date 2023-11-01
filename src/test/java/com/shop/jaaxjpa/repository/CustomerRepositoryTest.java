package com.shop.jaaxjpa.repository;

import com.shop.jaaxjpa.entity.Address;
import com.shop.jaaxjpa.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.adapter.AdvisorAdapterRegistrationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;


    //@Test
    public void save(){
        Customer customer = Customer.builder()
                .firstName("mayo")
                .lastName("isama")
                .email("mayo@gmail.com")
                .build();

        customerRepository.save(customer);

    }

    //@Test
    public void findByName(){
        String fistName= "mayo";
        Customer customer = customerRepository.findByFirstName(fistName);
        System.out.println(customer);
    }
    //@Test
    public void saveCustomerAndAddress(){
        Address address = Address.builder()
                .city("mex")
                .mainStreet("cambay")
                .secondStreet("tinia")
                .build();

        Customer customer = Customer.builder()
                .firstName("jose")
                .lastName("isaac")
                .email("joseIsaac@gmail.com")
                .address(address)
                .build();

        customerRepository.save(customer);

    }
    //@Test
    public void getByMainStreet(){
        String email = "joseIsaac@gmail.com";

        List<Customer> deCambay =customerRepository.getByEmail(email);
        for (Customer c: deCambay) {
            System.out.println(c);
        }

    }

    //@Test
    public void getByMainStreetImpl(){
        String mainStreet= "cambay";
        List<Customer> deCambay= customerRepository.getByMainStreet(mainStreet);
        for(Customer c: deCambay){
            System.out.println(c);
        }
    }

    //@Test
    public void updateNameByEmail(){
        customerRepository.updateNameByEmail("andrik", "andreko@gmail.com");
    }

}