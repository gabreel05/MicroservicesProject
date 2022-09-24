package br.com.vehicles.repository;

import br.com.vehicles.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle findByUserId(Long userId);
}
