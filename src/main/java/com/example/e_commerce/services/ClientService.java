package com.example.e_commerce.services;

import com.example.e_commerce.dtos.requests.ClientRequest;
import com.example.e_commerce.dtos.response.CategoryResponse;
import com.example.e_commerce.dtos.response.ClientResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public interface ClientService {
    ClientResponse createClient(ClientRequest clientRequest);
    ClientResponse getClientById(Long id);
    List<ClientResponse> getAllClients();
    ClientResponse updateClient(ClientRequest clientRequest,Long id);
    HashMap<String,String> deleteClient(Long id);
}
