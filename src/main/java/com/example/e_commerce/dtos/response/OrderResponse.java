package com.example.e_commerce.dtos.response;

import com.example.e_commerce.dtos.requests.OrderRequest;
import com.example.e_commerce.models.Client;
import com.example.e_commerce.models.Driver;
import com.example.e_commerce.models.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long id;
    private String ref;
    private  String description;
    int qte_total;
    double priceTotal;
    boolean state;
    List<ProductResponse> products;
    private Client client;
    private Driver driver ;
    public static OrderResponse fromEntity(Order order){
        OrderResponse orderResponse = new OrderResponse();
        BeanUtils.copyProperties(order,orderResponse);
        if (order.getProducts()!=null){
           orderResponse.setProducts(order.getProducts().
                    stream().map(ProductResponse::fromEntity).
                   collect(Collectors.toList()));
        }
        return  orderResponse;
    }
    public static Order toEntity(OrderRequest orderRequest){
        Order order = new Order();
        BeanUtils.copyProperties(orderRequest, order);
        return  order ;

    }
}
