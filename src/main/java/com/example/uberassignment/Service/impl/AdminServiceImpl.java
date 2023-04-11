package com.example.uberassignment.Service.impl;

import com.example.uberassignment.Model.Admin;
import com.example.uberassignment.Model.Customer;
import com.example.uberassignment.Model.Driver;
import com.example.uberassignment.Repository.AdminRepository;
import com.example.uberassignment.Repository.CustomerRepository;
import com.example.uberassignment.Repository.DriverRepository;
import com.example.uberassignment.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void adminRegister(Admin admin){
        adminRepository.save(admin);
    }

    @Override
    public Admin updatePassword(Integer adminId, String password) {
        Admin admin = adminRepository.findById(adminId).get();
        admin.setPassword(password);
        adminRepository.save(admin);
        return admin;
    }

    @Override
    public void deleteAdmin(int adminId){
        adminRepository.deleteById(adminId);
    }

    @Override
    public List<Driver> getListOfDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public List<Customer> getListOfCustomers() {
        return customerRepository.findAll();
    }
}
