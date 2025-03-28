package com.example.e_commerce.controllers;

import com.example.e_commerce.dtos.requests.OrderRequest;
import com.example.e_commerce.dtos.requests.ProductRequest;
import com.example.e_commerce.dtos.response.OrderResponse;
import com.example.e_commerce.dtos.response.ProductResponse;
import com.example.e_commerce.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/productapi")
public class ProductController {
    public static ProductService productService;
    public ProductController( ProductService productService) {
        this.productService=productService;
    }
    @PostMapping("/createProduct")
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }
    @PostMapping("/createProductWithSubCategoryProvider/{providerId}/categoryId")
    public ProductResponse createProductWithSubCategoryProvider(@PathVariable Long providerId,@PathVariable Long SubCatgeoryId ,@RequestBody ProductRequest productRequest) {
        return productService.createProductWithSubCategoryProvider(productRequest,SubCatgeoryId,providerId);
    }
    @GetMapping("/getAllProducts")
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping ("/getProductById/{id}")
    public ProductResponse getResponseById(@PathVariable Long id) {
        return  productService.getProduct(id) ;  }
    @PutMapping("/updateProduct/{id}")
    public ProductResponse updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        return productService.updateProduct(productRequest, id);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public HashMap<String, String> deleteOrderById(@PathVariable Long id) {
        return productService.dleteProduct(id);
    }
}
