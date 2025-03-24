package com.example.e_commerce.services.implement;

import com.example.e_commerce.dtos.requests.ProductRequest;
import com.example.e_commerce.dtos.response.ProductResponse;
import com.example.e_commerce.dtos.response.ProviderResponse;
import com.example.e_commerce.models.Product;
import com.example.e_commerce.models.Provider;
import com.example.e_commerce.repositories.ProductDAO;
import com.example.e_commerce.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductServiceImp implements ProductService {
    public static ProductDAO productdao;
    private final ProductDAO productDAO;

    public ProductServiceImp(ProductDAO productdao, ProductDAO productDAO) {
        ProductServiceImp.productdao = productdao;
        this.productDAO = productDAO;
    }
    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
      Product product = ProductResponse.toEntity(productRequest);
      Product savedProduct=productdao.save(product);
      return  ProductResponse.fromEntity(savedProduct);
    }

    @Override
    public ProductResponse getProduct(Long id) {
        return productdao.findById(id).map(ProductResponse::fromEntity).
                orElseThrow(()->new RuntimeException("product not found"));
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productdao.findAll().stream()
                .map(ProductResponse::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse updateProduct(ProductRequest productreuest, Long id) {

       Product product =productdao.findById(id).orElseThrow(
                ()->new RuntimeException("Product not found with this id:"+id));
        if(product !=null){
            Product p =ProductResponse.toEntity(productreuest);
            p.setId(id);
            Product savedProduct=productdao.save(p);
            return ProductResponse.fromEntity(savedProduct);
        }else{
            return  null;
        }

    }

    @Override
    public HashMap<String, String> dleteProduct(Long id) {

        HashMap message = new HashMap<>() ;
        Product product=productDAO.findById(id).orElseThrow(null);
        if(product!=null){
            try{
                productDAO.deleteById(id);
                message.put("Provider","provider deleted successfully");
            }catch(Exception e){
                message.put("provider",e.getMessage());
            }
        }else {
            message.put("message", "provider not found" + id);
        }
        return message;
    }
}
