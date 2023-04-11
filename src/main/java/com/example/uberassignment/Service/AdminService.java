package com.example.uberassignment.Service;

import com.example.uberassignment.Model.Admin;
import com.example.uberassignment.Model.Customer;
import com.example.uberassignment.Model.Driver;

import java.util.List;

public interface AdminService {
    public void adminRegister(Admin admin);


    public Admin updatePassword(Integer adminId, String password);

    public void deleteAdmin(int adminId);

    public List<Driver> getListOfDrivers();

    public List<Customer> getListOfCustomers();
}
