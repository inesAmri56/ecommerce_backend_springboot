package com.example.e_commerce.services.implement;

import com.example.e_commerce.dtos.requests.OrderRequest;
import com.example.e_commerce.dtos.response.CategoryResponse;
import com.example.e_commerce.dtos.response.OrderResponse;
import com.example.e_commerce.models.Category;
import com.example.e_commerce.models.Order;
import com.example.e_commerce.repositories.OrderDAO;
import com.example.e_commerce.services.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class OrderServiceImp implements OrderService {

    public static OrderDAO orderdao;
    public OrderServiceImp (OrderDAO orderdao) {
        OrderServiceImp.orderdao = orderdao;
    }
    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
       Order order = OrderResponse.toEntity(orderRequest);
       Order orderSaved= orderdao.save(order);
       return OrderResponse.fromEntity(orderSaved);

    }

    @Override
    public OrderResponse getOrder(Long id) {
        return orderdao.findById(id).
                map(OrderResponse::fromEntity).
                orElseThrow(()->new RuntimeException("order not found"));
    }

    @Override
    public List<OrderResponse> getAllOrder() {
        return orderdao.findAll().stream().
                map(OrderResponse::fromEntity).collect(Collectors.toList());
    }

    @Override
    public OrderResponse upDateOrder( OrderRequest orderRequest,  Long id) {
        Order order =orderdao.findById(id).orElseThrow(
                ()->new RuntimeException("order not found with this id:"+id));
        if(order !=null){
           Order o = OrderResponse.toEntity(orderRequest);
            o.setId(id);
           Order savedOrder=orderdao.save(o);
            return OrderResponse.fromEntity(savedOrder);
        }else{
            return  null;
        }

    }

    @Override
    public HashMap<String, String> deleteOrder(Long id) {
        HashMap message = new HashMap<>() ;
       Order order=orderdao.findById(id).orElseThrow(null);
        if(order!=null){
            try{
            orderdao.deleteById(id);
                message.put("Order","Order deleted successfully");
            }catch(Exception e){
                message.put("Order",e.getMessage());
            }
        }else {
            message.put("message", "Order not found" + id);
        }
        return message;
    }
}
