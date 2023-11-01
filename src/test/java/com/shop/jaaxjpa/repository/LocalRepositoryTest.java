package com.shop.jaaxjpa.repository;

import com.shop.jaaxjpa.entity.Local;
import com.shop.jaaxjpa.entity.Manager;
import com.shop.jaaxjpa.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class LocalRepositoryTest {

    @Autowired
    LocalRepository localRepository;

    //@Test
    public void saveLocal(){
        Manager manager= Manager.builder()
                .firstName("Mauricio")
                .lastName("Lira")
                .build();
        Order order = Order.builder()
                .description("unlimited power")
                .price(10.0)
                .build();
        Order order1 =Order.builder()
                .description("think and doing rich")
                .price(20.0)
                .build();
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        orders.add(order1);

        Local local = Local.builder()
                .name("Libreria")
                .floor("first")
                .manager(manager)
                //.orderList(orders)
                .build();
        localRepository.save(local);
    }
    
    @Test
    public void getAllLocal(){
        List<Local> locals = localRepository.findAll();
        System.out.println("locals = " + locals);
    }



}