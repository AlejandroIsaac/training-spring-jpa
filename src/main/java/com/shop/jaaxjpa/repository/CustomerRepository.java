package com.shop.jaaxjpa.repository;

import com.shop.jaaxjpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //query method
    Customer findByFirstName(String name);

    //jpql
    @Query("select c from Customer c where c.email =?1")
    List<Customer> getByEmail(String email);

    //query native
    @Query(
           nativeQuery = true,
           value = "select * from customer where customer_main_street= :mainStreet"
    )
    public List<Customer> getByMainStreet(@Param(value = "mainStreet") String mainStreet);

    //update query native
    @Transactional
    @Modifying
    @Query(
            nativeQuery = true,
            value = "update customer set first_name=:name where email_address=:email"
    )
    public void updateNameByEmail(@Param(value = "name") String name, @Param(value = "email") String email);
}
