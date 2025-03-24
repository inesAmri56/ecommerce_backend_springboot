package com.example.e_commerce.services;

import com.example.e_commerce.dtos.requests.ProviderRequest;
import com.example.e_commerce.dtos.response.ProviderResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public interface ProviderService {
    ProviderResponse createProvider(ProviderRequest providerRequest );
    ProviderResponse getPovider(Long id);
    List<ProviderResponse> getAllPriver();
    ProviderResponse updateProvider(ProviderRequest providerRequest , Long id);
    HashMap<String,String> deleteProvider(Long id);
}
