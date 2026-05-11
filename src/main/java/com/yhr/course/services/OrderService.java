package com.yhr.course.services;

import com.yhr.course.entities.Order;
import com.yhr.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
//        Optional<Order> obj = orderRepository.findById(id);
//        return obj.get();
        return orderRepository.findById(id).orElse(null);

    }
}
