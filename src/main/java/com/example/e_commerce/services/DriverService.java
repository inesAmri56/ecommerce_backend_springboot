package com.example.e_commerce.services;

import com.example.e_commerce.dtos.requests.DriverRequest;
import com.example.e_commerce.dtos.response.DriverResponse;
import com.example.e_commerce.models.Driver;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public interface DriverService {
    DriverResponse createDriver(DriverRequest driverRequest);
    DriverResponse getDriver(Long id);
    List<DriverResponse> getAllDrivers();
    DriverResponse updateDriver(DriverRequest driverRequest,Long id);
    HashMap<String , String >deleteDriver(Long id);
}
