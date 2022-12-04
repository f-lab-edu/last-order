package com.flab.order.controller;

import com.flab.order.domain.Order;
import com.flab.user.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/add")
    public Order addOrder() {
        User user = new User("슈카", 43);
        Order order = Order.builder()
                .name("첫 주문")
                .user(user).build();
        return order;
    }

    @PostMapping("/update")
    public String updateOrder() {
        return "update";
    }

    @DeleteMapping("/delete")
    public String deleteOrder() {
        return "delete";
    }

    @GetMapping("/list")
    public List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();
        User user = new User("슈카", 43);
        Order order1 = Order.builder()
                .name("주문1")
                .user(user).build();
        Order order2 = Order.builder()
                .name("주문2")
                .user(user).build();
        orders.add(order1);
        orders.add(order2);
        return orders;
    }
}
