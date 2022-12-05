package com.example.vehicle.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
