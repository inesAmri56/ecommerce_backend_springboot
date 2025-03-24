package com.example.e_commerce.services.implement;

import com.example.e_commerce.dtos.requests.ClientRequest;
import com.example.e_commerce.dtos.response.CategoryResponse;
import com.example.e_commerce.dtos.response.ClientResponse;
import com.example.e_commerce.models.Client;
import com.example.e_commerce.repositories.ClientDAO;
import com.example.e_commerce.services.CategoryService;
import com.example.e_commerce.services.ClientService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImp implements ClientService {
    public static ClientDAO clientDao;
    public ClientServiceImp(ClientDAO clientDao){
        this.clientDao = clientDao;
    }
    @Override
    public ClientResponse createClient(ClientRequest clientRequest) {
        Client client = ClientResponse.toEntity(clientRequest);
        Client saveClient= clientDao.save(client);
        return ClientResponse.fromEntity(saveClient) ;
    }

    @Override
    public ClientResponse getClientById(Long id) {
        return clientDao.findById(id).map(ClientResponse ::fromEntity)
                .orElseThrow(()->new RuntimeException("cleint not fount"));
    }

    @Override
    public List<ClientResponse> getAllClients() {
        return clientDao.findAll().stream().map(ClientResponse ::fromEntity).
                collect(Collectors.toList());    }

    @Override
    public ClientResponse updateClient(ClientRequest clientRequest, Long id) {
        Client client = clientDao.findById(id).orElseThrow(
                ()->new RuntimeException("client not found"));
        if(client !=null){
        Client c = ClientResponse.toEntity(clientRequest);
        c.setId(id);
        Client savedClient = clientDao.save(c);
        return  ClientResponse.fromEntity(savedClient);
    } else{return null ;}
    }

    @Override
    public HashMap<String, String> deleteClient(Long id) {
        HashMap message = new HashMap<>();
        Client client = clientDao.findById(id).orElseThrow(null);
        if(client !=null){
            try{
                clientDao.deleteById(id);
                message.put("client","client deleted successfully");
            }catch(Exception e){
                message.put("client",e.getMessage());
            }
        }else {
            message.put("message", "client not found" + id);
        }
        return message;
    }
}
