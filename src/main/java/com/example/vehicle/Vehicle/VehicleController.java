package com.example.vehicle.Vehicle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping()
    public List<Vehicle> getVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping(path = "{vehicleId}")
    public Vehicle getVehicle(@PathVariable Long vehicleId) {
        return vehicleService.getVehicleById(vehicleId);
    }

    @PostMapping()
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleService.createVehicle(vehicle);
    }

    @DeleteMapping(path = "{vehicleId}")
    public String deleteVehicle(@PathVariable Long vehicleId) {
        return vehicleService.deleteVehicleById(vehicleId);
    }

    @PutMapping(path = "{vehicleId}")
    public Vehicle updateVehicle(@PathVariable Long vehicleId, @RequestBody Vehicle vehicleBody) {
        return vehicleService.updateVehicleById(vehicleId, vehicleBody);
    }

}
