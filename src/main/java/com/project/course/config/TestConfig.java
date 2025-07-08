package com.project.course.config;

import com.project.course.entities.Category;
import com.project.course.entities.Order;
import com.project.course.entities.User;
import com.project.course.enums.OrderStatus;
import com.project.course.repositories.CategoryRepository;
import com.project.course.repositories.OrderRepository;
import com.project.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1= new User(null,"Maria Brown","maria@gmail.com","963271973","12345");
        User u2= new User(null,"Alex Green","alex@gmail.com","963316173","12431");

        Order o1=new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,u1);
        Order o2=new Order(null, Instant.parse("2019-06-21T15:21:01Z"),OrderStatus.WAITING_PAYMENT,u2);
        Order o3=new Order(null, Instant.parse("2019-07-22T10:22:21Z"),OrderStatus.WAITING_PAYMENT,u1);

        Category c1=new Category(null,"Eletronics");
        Category c2=new Category(null,"Books");
        Category c3=new Category(null,"Computers");


        userRepository.saveAll(Arrays.asList(u1,u2));

        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));

    }
}
