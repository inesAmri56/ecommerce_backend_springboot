package com.example.e_commerce.controllers;

import com.example.e_commerce.dtos.requests.OrderRequest;
import com.example.e_commerce.dtos.requests.ProviderRequest;
import com.example.e_commerce.dtos.response.OrderResponse;
import com.example.e_commerce.dtos.response.ProviderResponse;
import com.example.e_commerce.services.ProductService;
import com.example.e_commerce.services.ProviderService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/providerapi")
public class ProviderController {


    public static ProviderService providerService;
    private final ProductService productService;

    public ProviderController(ProviderService providerService, ProductService productService) {
        this.providerService=providerService;
        this.productService = productService;
    }
    @PostMapping("/createProvider")
    public ProviderResponse createProvider(@RequestBody ProviderRequest providerRequest) {
        return providerService.createProvider(providerRequest);
    }
    @GetMapping("/getProviderById/{id}")
    public ProviderResponse getProviderById(@PathVariable Long id) {
        return providerService.getPovider(id);
    }
    @GetMapping ("/getAllProviders")
    public List<ProviderResponse> getAllResponse(){
        return providerService.getAllPriver();
    }
    @PutMapping("/updateProvider/{id}")
    public ProviderResponse updateClient(@PathVariable Long id, @RequestBody ProviderRequest providerRequest) {
        return providerService.updateProvider(providerRequest, id);
    }

    @DeleteMapping("/deleteProvider/{id}")
    public HashMap<String, String> deleteOrderById(@PathVariable Long id) {
        return productService.dleteProduct(id);
    }
}
