package com.example.vehicle.Vehicle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    /**
     * It returns a list of all the vehicles in the database
     * 
     * @return A list of all vehicles in the database.
     */
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    /**
     * If the vehicle exists, return it. If it doesn't, throw an exception
     * 
     * @param vehicleId The id of the vehicle to be retrieved.
     * @return A vehicle object
     */
    public Vehicle getVehicleById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new IllegalStateException("No vehicle with id " + vehicleId));
    }

    /**
     * This function creates a new vehicle in the database
     * 
     * @param vehicle The vehicle object that is being created.
     * @return The vehicle object is being returned.
     */
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    /**
     * It deletes a vehicle from the database by its id
     * 
     * @param vehicleId The id of the vehicle to be deleted.
     * @return A String
     */
    public String deleteVehicleById(Long vehicleId) {
        vehicleRepository.deleteById(vehicleId);
        return "Deleted";
    }

    /**
     * If the vehicle exists, update it with the new values, otherwise throw an
     * exception
     * 
     * @param vehicleId  The id of the vehicle to be updated
     * @param newVehicle This is the new vehicle object that we want to update the
     *                   existing vehicle
     *                   with.
     * @return The vehicle object is being returned.
     */

    public Vehicle updateVehicleById(Long vehicleId, Vehicle newVehicle) {
        return vehicleRepository.findById(vehicleId).map(vehicle -> {
            vehicle.setBrand(newVehicle.getBrand());
            vehicle.setName(newVehicle.getName());
            vehicle.setYear(newVehicle.getYear());
            vehicle.setCostperkm(newVehicle.getCostperkm());
            vehicle.setColour(newVehicle.getColour());

            return vehicleRepository.save(vehicle);
        }).orElseThrow(() -> new IllegalStateException("No Vehicle with id " + vehicleId));
    }

}
