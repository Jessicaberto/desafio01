package com.devsuperior.desafio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.devsuperior.entities.Order;
import com.devsuperior.services.OrderService;

@SpringBootApplication
@ComponentScan(basePackages = {"com.devsuperior.desafio", "com.devsuperior.services"})
public class DesafioApplication implements CommandLineRunner {

    private final OrderService orderService;

    public DesafioApplication(OrderService orderService) {
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DesafioApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Order order1 = new Order(1034, 150.0, 20.0);
        System.out.printf("Pedido código %d Valor total: R$ %.2f%n", 
                          order1.getCode(), orderService.total(order1));

        Order order2 = new Order(2282, 800.0, 10.0);
        System.out.printf("Pedido código %d Valor total: R$ %.2f%n", 
                          order2.getCode(), orderService.total(order2));

        Order order3 = new Order(1309, 95.90, 0.0);
        System.out.printf("Pedido código %d Valor total: R$ %.2f%n", 
                          order3.getCode(), orderService.total(order3));
    }
}


   