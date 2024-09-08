package com.emirhanarici.OrderService.repository;

import com.emirhanarici.OrderService.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
