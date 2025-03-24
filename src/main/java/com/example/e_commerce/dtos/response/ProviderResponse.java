package com.example.e_commerce.dtos.response;

import com.example.e_commerce.dtos.requests.ProviderRequest;
import com.example.e_commerce.models.Product;
import com.example.e_commerce.models.Provider;
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
public class ProviderResponse {
    private Long id;
    private String company;
    List<ProductResponse> products;
    public static ProviderResponse fromEntity(Provider provider){
        ProviderResponse providerResponse = new ProviderResponse();
        BeanUtils.copyProperties(provider,providerResponse);
        if(provider.getProducts()!=null){
            providerResponse.setProducts(
                    provider.getProducts().stream().map(
                            ProductResponse::fromEntity).collect(Collectors.toList())
            );
        }
        return providerResponse;
    }
    public static Provider toEntity(ProviderRequest providerRequest){
        Provider  provider = new Provider();
        BeanUtils.copyProperties(providerRequest,provider);
        return  provider;
    }
}
