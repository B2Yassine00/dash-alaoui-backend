package com.thrilling.dashboard.dashboardAlaoui.repositories;

import com.thrilling.dashboard.dashboardAlaoui.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
