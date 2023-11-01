package com.shop.jaaxjpa.repository;

import com.shop.jaaxjpa.entity.Local;
import com.shop.jaaxjpa.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangerRepository extends JpaRepository<Manager, Long> {

}
