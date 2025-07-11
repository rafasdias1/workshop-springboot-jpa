package com.project.course.services;

import com.project.course.entities.Order;
import com.project.course.entities.User;
import com.project.course.repositories.OrderRepository;
import com.project.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();

    }

    public Order findById(Long id){
        Optional<Order> obj= orderRepository.findById(id);
        return obj.get();
    }

}
