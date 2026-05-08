package com.yhr.course.config;

import com.yhr.course.entities.Order;
import com.yhr.course.entities.User;
import com.yhr.course.entities.enums.OrderStatus;
import com.yhr.course.repositories.OrderRepository;
import com.yhr.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired // spring padrao de DI
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override // popula o database assim que roda a app
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria", "maria@gmail.com", "988888888", "12345");
        User u2 = new User(null, "John", "john@gmail.com", "977777777", "123");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,u1); // no banco de dados fica local (h2)
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.DELIVERED,u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED,u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
