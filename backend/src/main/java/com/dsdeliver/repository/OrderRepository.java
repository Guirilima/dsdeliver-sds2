package com.dsdeliver.repository;

import com.dsdeliver.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query("SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.products " +
            "WHERE obj.status = 0 ORDER BY obj.moment ASC ") //JPQL
    List<Order> findOrdersWithProducts();

}
