package com.example.vehicle.User;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    Boolean existsByEmail(String email);
}
