package br.com.vehicles.controller;

import br.com.vehicles.model.Vehicle;
import br.com.vehicles.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> findAll() {
        List<Vehicle> vehicles = vehicleRepository.findAll();

        return ResponseEntity.ok(vehicles);
    }

    @PostMapping
    public ResponseEntity<Vehicle> save(@RequestBody Vehicle user, UriComponentsBuilder uriComponentsBuilder) {
        Vehicle v = vehicleRepository.save(user);

        URI uri = uriComponentsBuilder.path("/api/vehicles/{id}").buildAndExpand(v.getId()).toUri();

        return ResponseEntity.created(uri).body(v);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<Vehicle> findByUserId(@PathVariable Long userId) {
        Vehicle vehicle = vehicleRepository.findByUserId(userId);

        return ResponseEntity.ok(vehicle);
    }
}
