package com.shop.jaaxjpa.repository;

import com.shop.jaaxjpa.entity.Local;
import com.shop.jaaxjpa.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void save(){
        Local local = Local.builder()
                .name("pcshop")
                .floor("second")
                .build();

        Order order = Order.builder()
                .description("teclado")
                .price(200.0)
                .local(local)
                .build();


        orderRepository.save(order);
    }



}