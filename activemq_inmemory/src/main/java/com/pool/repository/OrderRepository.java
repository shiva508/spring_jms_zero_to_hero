package com.pool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shiva.model.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
