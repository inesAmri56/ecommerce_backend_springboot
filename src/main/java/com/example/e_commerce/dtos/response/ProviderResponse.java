package com.example.e_commerce.dtos.response;

import com.example.e_commerce.dtos.requests.ProviderRequest;
import com.example.e_commerce.models.Provider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProviderResponse {
    private Long id;
    private String company;
    public static ProviderResponse fromEntity(Provider provider){
        ProviderResponse providerResponse = new ProviderResponse();
        BeanUtils.copyProperties(provider,providerResponse);
        return providerResponse;
    }
    public static Provider toEntity(ProviderRequest providerRequest){
        Provider  provider = new Provider();
        BeanUtils.copyProperties(providerRequest,provider);
        return  provider;
    }
}
