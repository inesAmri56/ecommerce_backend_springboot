package com.example.e_commerce.services;

import com.example.e_commerce.dtos.requests.OrderRequest;
import com.example.e_commerce.dtos.response.GalleryResponse;
import com.example.e_commerce.dtos.response.OrderResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public interface OrderService {
OrderResponse createOrder(OrderRequest orderRequest);
OrderResponse getOrder(Long id);
List<OrderResponse> getAllOrder();
OrderResponse upDateOrder(OrderRequest orderRequest , Long id);
HashMap<String , String> deleteOrder(Long id);
OrderResponse createOrderWithClientAndDriver(OrderRequest orderRequest, Long ClientId,Long driverId);

}
