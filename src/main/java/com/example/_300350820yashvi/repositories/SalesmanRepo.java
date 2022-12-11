package com.example._300350820yashvi.repositories;

import com.example._300350820yashvi.entities.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesmanRepo extends JpaRepository<Salesman,Long> {
    List<Salesman> findSalesmanById(Long id);


}
