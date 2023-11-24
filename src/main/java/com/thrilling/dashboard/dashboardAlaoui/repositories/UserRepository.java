package com.thrilling.dashboard.dashboardAlaoui.repositories;

import com.thrilling.dashboard.dashboardAlaoui.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
