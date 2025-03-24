package com.example.e_commerce.controllers;

import com.example.e_commerce.dtos.requests.ClientRequest;
import com.example.e_commerce.dtos.requests.OrderRequest;
import com.example.e_commerce.dtos.response.ClientResponse;
import com.example.e_commerce.dtos.response.OrderResponse;
import com.example.e_commerce.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/orderapi")
public class OrderController {
    public static OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/createOrder")
    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    @GetMapping("/getAllOrders")
    public List<OrderResponse> getAllOrders() {
        return orderService.getAllOrder();
    }

    @GetMapping("/orderById/{id}")
    public OrderResponse getOrderById(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @PutMapping("/updateOrder/{id}")
    public OrderResponse updateClient(@PathVariable Long id, @RequestBody OrderRequest orderRequest) {
        return orderService.upDateOrder(orderRequest, id);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public HashMap<String, String> deleteOrderById(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }
}