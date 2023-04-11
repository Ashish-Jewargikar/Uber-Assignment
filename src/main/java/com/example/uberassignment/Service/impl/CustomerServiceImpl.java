package com.example.uberassignment.Service.impl;

import com.example.uberassignment.Enum.TripStatus;
import com.example.uberassignment.Model.Customer;
import com.example.uberassignment.Model.Driver;
import com.example.uberassignment.Model.TripBooking;
import com.example.uberassignment.Repository.CabRepository;
import com.example.uberassignment.Repository.CustomerRepository;
import com.example.uberassignment.Repository.DriverRepository;
import com.example.uberassignment.Repository.TripBookingRepository;
import com.example.uberassignment.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    TripBookingRepository tripBookingRepository;

    @Autowired
    private CabRepository cabRepository;
    @Override
    public void register(Customer customer) {

        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        customerRepository.delete(customer);
    }

    @Override
    public TripBooking bookTrip(int customerId, String fromLocation, String toLocation, int distanceInKm) throws Exception {

        List<Driver> drivers = driverRepository.findAll();
        Driver driver = null;
        for(Driver currentDriver : drivers){
            if(currentDriver.getCab().isAvailable()){
             if(driver == null || currentDriver.getDriverId() < driver.getDriverId()){
                 driver=currentDriver;
             }
            }
        }
        if(driver == null){
            throw new Exception("No Cab Available");
        }
        driver.getCab().setAvailable(false);
        TripBooking tripBooking = new TripBooking();

        Customer customer = customerRepository.findById(customerId).get();

        tripBooking.setFromBooking(fromLocation);
        tripBooking.setToLocation(toLocation);
        tripBooking.setTripStatus(TripStatus.COMPLETED);
        tripBooking.setDistance(distanceInKm);
        tripBooking.setBill(driver.getCab().getRatePerKm()*distanceInKm);
        tripBooking.setCustomer(customer);
        tripBooking.setDriver(driver);

        customer.getTripBookingList().add(tripBooking);
        customerRepository.save(customer);
        driver.getTripBookingList().add(tripBooking);
        driverRepository.save(driver);
        return tripBooking;
    }

    @Override
    public void cancelTrip(Integer tripId) {
      TripBooking tripBooking = tripBookingRepository.findById(tripId).get();
      tripBooking.setTripStatus(TripStatus.CANCELED);
      tripBooking.setBill(0);
      tripBooking.getDriver().getCab().setAvailable(Boolean.TRUE);
      tripBookingRepository.save(tripBooking);
    }

    @Override
    public void completeTrip(Integer tripId) {
       TripBooking tripBooking = tripBookingRepository.findById(tripId).get();
       tripBooking.setTripStatus(TripStatus.COMPLETED);
       tripBooking.getDriver().getCab().setAvailable(true);
       tripBookingRepository.save(tripBooking);
    }
}
