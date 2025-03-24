package com.example.e_commerce.controllers;

import com.example.e_commerce.dtos.requests.ClientRequest;
import com.example.e_commerce.dtos.requests.DriverRequest;
import com.example.e_commerce.dtos.response.ClientResponse;
import com.example.e_commerce.dtos.response.DriverResponse;
import com.example.e_commerce.services.DriverService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/driverapi")
public class DriverController {
    public static DriverService driverService;
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }
    @PostMapping("/createDriver")
    public DriverResponse createDriver(@RequestBody DriverRequest driverRequest){
        return driverService.createDriver(driverRequest);
    }
    @GetMapping("/getAllDrivers")
    public List<DriverResponse> getAllDrivers(){
        return driverService.getAllDrivers();
    }
    @GetMapping("/getDriverById/{id}")
    public DriverResponse getDrriverById(@PathVariable Long id){

        return driverService.getDriver(id);
    }
    @PutMapping("/updateDriver/{id}")
    public DriverResponse updateDriver(@PathVariable Long id, @RequestBody DriverRequest driverRequest) {
        return driverService.updateDriver(driverRequest, id);
    }

    @DeleteMapping("/deleteDriver/{id}")
    public HashMap<String, String> deleteDriverById(@PathVariable Long id) {
        return driverService.deleteDriver(id);
}}
