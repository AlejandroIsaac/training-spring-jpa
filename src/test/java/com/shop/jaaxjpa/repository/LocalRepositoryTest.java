package com.shop.jaaxjpa.repository;

import com.shop.jaaxjpa.entity.*;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LocalRepositoryTest {

    @Autowired
    LocalRepository localRepository;

    @Test
    public void saveLocal(){
        //Adrress customer
        Address address =Address.builder()
                .mainStreet("cambay")
                .secondStreet("tinia")
                .city("mex")
                .build();
        //Customer
        Customer customer = Customer.builder()
                .firstName("miguel")
                .lastName("tio Rata")
                .email("miki@gmail.com")
                .address(address)
                .build();
        Customer customer1 = Customer.builder()
                .firstName("mario")
                .lastName("isaac")
                .email("mario@gmail.com")
                .address(address)
                .build();

        Local local = Local.builder()
                .name("Pizzeria")
                .floor("first")
                //.manager(manager)
                .customerList(List.of(customer, customer1))
                //.orderList(orders)
                .build();
        localRepository.save(local);
    }
    
    //@Test
    public void getAllLocal(){
        List<Local> locals = localRepository.findAll();
        System.out.println("locals = " + locals);
    }

    @Test
    public void getLocals (){
        List<Local> localList= localRepository.findAll();
        System.out.println(localList);

    }

    @Test
    public void getLocalById(){
        Local local = localRepository.findById(102L).get();
        System.out.println(local);
    }



}