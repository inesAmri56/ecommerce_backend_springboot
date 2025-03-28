package com.example.e_commerce.services.implement;

import com.example.e_commerce.dtos.requests.OrderRequest;
import com.example.e_commerce.dtos.requests.ProductRequest;
import com.example.e_commerce.dtos.response.OrderResponse;
import com.example.e_commerce.dtos.response.ProductResponse;
import com.example.e_commerce.dtos.response.ProviderResponse;
import com.example.e_commerce.models.Order;
import com.example.e_commerce.models.Product;
import com.example.e_commerce.models.Provider;
import com.example.e_commerce.models.SubCategory;
import com.example.e_commerce.repositories.OrderDAO;
import com.example.e_commerce.repositories.ProductDAO;
import com.example.e_commerce.repositories.ProviderDAO;
import com.example.e_commerce.repositories.SubCategoryDAO;
import com.example.e_commerce.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductServiceImp implements ProductService {
    public static ProductDAO productdao;
    private final ProductDAO productDAO;
    private final OrderDAO orderDAO;
    private final SubCategoryDAO subCategoryDAO;
    private final ProviderDAO providerDAO;

    public ProductServiceImp(ProductDAO productdao, ProductDAO productDAO, OrderDAO orderDAO, SubCategoryDAO subCategoryDAO, ProviderDAO providerDAO) {
        ProductServiceImp.productdao = productdao;
        this.productDAO = productDAO;
        this.orderDAO = orderDAO;
        this.subCategoryDAO = subCategoryDAO;
        this.providerDAO = providerDAO;
    }
    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
      Product product = ProductResponse.toEntity(productRequest);
      Product savedProduct=productdao.save(product);
      return  ProductResponse.fromEntity(savedProduct);
    }
    @Override
    public ProductResponse createProductWithSubCategoryProvider(ProductRequest productrequest, Long providerId,Long SubCategoryId) {
        SubCategory subCategory = subCategoryDAO.findById(SubCategoryId).orElseThrow(()->new RuntimeException("subCategory not found"));
        Product product = ProductResponse.toEntity(productrequest);
        product.setSubcategory(subCategory);
        Provider provider = providerDAO.findById(providerId).orElseThrow(()->new RuntimeException("provider not found"));
        Product savedProduct = productdao.save(product);
        return ProductResponse.fromEntity(savedProduct);}

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
