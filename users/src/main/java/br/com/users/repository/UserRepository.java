package br.com.users.repository;

import br.com.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByVehicleId(Long id);

    Optional<User> findByName(String username);
}
