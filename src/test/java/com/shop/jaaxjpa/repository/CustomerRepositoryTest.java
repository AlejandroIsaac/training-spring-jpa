package com.shop.jaaxjpa.repository;

import com.shop.jaaxjpa.entity.Address;
import com.shop.jaaxjpa.entity.Customer;
import com.shop.jaaxjpa.entity.Local;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.adapter.AdvisorAdapterRegistrationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;


    @Test
    public void save(){
        Address address =Address.builder()
                .city("mex")
                .mainStreet("atlacomulco")
                .secondStreet("san lorenzo")
                .build();

        Customer customer = Customer.builder()
                .firstName("cuautemoc")
                .lastName("blanco")
                .email("cua@gmail.com")
                .address(address)
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

    @Test
    public void getCustomerPagination(){
        //paginacion
        Pageable firstPage = PageRequest.of(0, 5);
        List<Customer> customers = customerRepository.findAll(firstPage).getContent();
        long totalElements= customerRepository.findAll(firstPage).getTotalElements();
        int totalPages= customerRepository.findAll(firstPage).getTotalPages();

        System.out.println("Records: "+totalElements);
        System.out.println("Pages: "+totalPages);
        System.out.println(customers);
    }
    @Test
    public void getCustomerPaginationDynamic(){
        int numberPage= 1;
        final int SIZE=3;
        Pageable pageable = PageRequest.of(numberPage,SIZE);
        List<Customer> customers = customerRepository.findAll(pageable).getContent();
        System.out.println(customers);
    }

    @Test
    public void getCustomerPaginationAndShort(){
        Sort sortDesc= Sort.by("firstName").descending();
        Pageable pageableAndShort = PageRequest.of(0,5,sortDesc);
        List<Customer> customers = customerRepository.findAll(pageableAndShort).getContent();
        System.out.println(customers);
    }

}