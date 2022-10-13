package com.example.spring_music.app.order.repository;

import com.example.spring_music.app.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
