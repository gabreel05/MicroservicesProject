package br.com.users.controller;

import br.com.users.model.VehicleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@FeignClient("vehicles")
public interface VehicleService {

    @GetMapping("/api/vehicles/users/{userId}")
    @Bean
    VehicleResponse findByUserId(@PathVariable Long userId);
}
