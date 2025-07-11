package com.project.course.config;

import com.project.course.entities.*;
import com.project.course.enums.OrderStatus;
import com.project.course.repositories.*;
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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1= new User(null,"Maria Brown","maria@gmail.com","963271973","12345");
        User u2= new User(null,"Alex Green","alex@gmail.com","963316173","12431");

        Order o1=new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,u1);
        Order o2=new Order(null, Instant.parse("2019-06-21T15:21:01Z"),OrderStatus.WAITING_PAYMENT,u2);
        Order o3=new Order(null, Instant.parse("2019-07-22T10:22:21Z"),OrderStatus.WAITING_PAYMENT,u1);

        userRepository.saveAll(Arrays.asList(u1,u2));

        orderRepository.saveAll(Arrays.asList(o1,o2,o3));


        Category c1 = new Category(null, "Eletronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");



        Product p1 = new Product(
                null,
                "The Lord of the Rings",
                "Lorem ipsum dolor sit amet, consectetur.",
                90.5,
                "https://img.com/lotr.jpg"
        );

        Product p2 = new Product(
                null,
                "Smart TV",
                "Nulla eu imperdiet purus. Maecenas ante.",
                2190.0,
                "https://img.com/tv.jpg"
        );

        Product p3 = new Product(
                null,
                "Macbook Pro",
                "Nam eleifend maximus tortor, at mollis.",
                1250.0,
                "https://img.com/macbook.jpg"
        );

        Product p4 = new Product(
                null,
                "PC Gamer",
                "Donec aliquet odio ac rhoncus cursus.",
                1200.0,
                "https://img.com/pcgamer.jpg"
        );

        Product p5 = new Product(
                null,
                "Rails for Dummies",
                "Cras fringilla convallis sem vel faucibus.",
                100.99,
                "https://img.com/rails.jpg"
        );

        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
        //productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));


        p1.getCategories().add(c2);
        p2.getCategories().add(c1);
        p2.getCategories().add(c3);
        p3.getCategories().add(c3);
        p4.getCategories().add(c3);
        p5.getCategories().add(c2);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));



        OrderItem oi1=new OrderItem(o1,p1,2,p1.getPrice());
        OrderItem oi2=new OrderItem(o1,p3,1,p4.getPrice());
        OrderItem oi3=new OrderItem(o2,p3,2,p1.getPrice());
        OrderItem oi4=new OrderItem(o3,p5,2,p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
    }
}
