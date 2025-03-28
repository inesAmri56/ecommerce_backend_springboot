package com.example.e_commerce.services;

import com.example.e_commerce.dtos.requests.ProductRequest;
import com.example.e_commerce.dtos.response.ProductResponse;
import com.example.e_commerce.models.SubCategory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);
    ProductResponse getProduct(Long id);
    List<ProductResponse> getAllProducts();
    ProductResponse updateProduct(ProductRequest productreuest, Long id);
    HashMap<String,String> dleteProduct(Long id);
    ProductResponse createProductWithSubCategoryProvider(ProductRequest productrequest, Long ProviderId,Long SubCategoryId);

}
