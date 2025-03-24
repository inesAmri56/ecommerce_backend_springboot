package com.example.e_commerce.dtos.response;

import com.example.e_commerce.dtos.requests.ProductRequest;
import com.example.e_commerce.models.Product;
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
public class ProductResponse {
    private Long id;
    double price;
    String ref;
    String description;
    int qte;
    List<OrderResponse> orders;
    public static ProductResponse fromEntity(Product product){
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product,productResponse);
        if(product.getOrders()!=null){
          productResponse.setOrders(
                  product.getOrders().stream().map(OrderResponse::fromEntity)
                          .collect(Collectors.toList()) );
        }
        return productResponse;
    }
    public static Product toEntity(ProductRequest productRequest){
        Product product = new Product();
        BeanUtils.copyProperties(productRequest,product);
        return product;
    }
}
