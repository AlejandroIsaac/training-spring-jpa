package com.shop.jaaxjpa.repository;

import com.shop.jaaxjpa.entity.Local;
import com.shop.jaaxjpa.entity.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class MangerRepositoryTest {
    @Autowired
    MangerRepository mangerRepository;

    @Test
    public void getAll(){
        List<Manager> managers= mangerRepository.findAll();
        System.out.println(managers);
    }

    //@Test
    public void save(){
        Manager manager =Manager.builder()
                .firstName("Victor")
                .lastName("lopez")
                .build();

        mangerRepository.save(manager);
    }

}