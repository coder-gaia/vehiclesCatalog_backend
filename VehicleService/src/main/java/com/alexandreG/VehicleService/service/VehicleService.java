/**
 * @author alexandre.gaia
 */

package com.alexandreG.VehicleService.service;

import com.alexandreG.VehicleService.models.Vehicle;
import com.alexandreG.VehicleService.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private IVehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> getVehicleById(String id) {
        return vehicleRepository.findById(id);
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicle(String id, Vehicle vehicleDetails) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        vehicle.setBrand(vehicleDetails.getBrand());
        vehicle.setModel(vehicleDetails.getModel());
        vehicle.setYear(vehicleDetails.getYear());
        vehicle.setColor(vehicleDetails.getColor());
        vehicle.setPrice(vehicleDetails.getPrice());
        vehicle.setKm(vehicleDetails.getKm());
        vehicle.setImage(vehicleDetails.getImage());
        vehicle.setLocation(vehicleDetails.getLocation());
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(String id) {
       Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
       vehicleRepository.delete(vehicle);
    }
}
