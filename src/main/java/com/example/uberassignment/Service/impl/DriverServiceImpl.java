package com.example.uberassignment.Service.impl;

import com.example.uberassignment.Model.Cab;
import com.example.uberassignment.Model.Driver;
import com.example.uberassignment.Repository.CabRepository;
import com.example.uberassignment.Repository.DriverRepository;
import com.example.uberassignment.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    CabRepository cabRepository;

    @Override
    public void register(String mobile,String password){
        Driver driver = new Driver();
        driver.setMobile(mobile);
        driver.setPassword(password);

        Cab cab = new Cab();
        cab.setAvailable(true);
        cab.setRatePerKm(10);
        cab.setDriver(driver);

        driver.setCab(cab);
        driverRepository.save(driver);
    }

    @Override
    public void removeDriver(int driverId) {
        driverRepository.deleteById(driverId);
    }

    @Override
    public void updateStatus(int driverId) {
     Driver driver = driverRepository.findById(driverId).get();
     driver.getCab().setAvailable(false);
     driverRepository.save(driver);
    }
}
