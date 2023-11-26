package com.thrilling.dashboard.dashboardAlaoui.services;

import com.thrilling.dashboard.dashboardAlaoui.entities.User;
import com.thrilling.dashboard.dashboardAlaoui.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public long totalUser(){
        return userRepository.countFirstBy();
    }
    public boolean verifiedExistingEmail(String email){

        return userRepository.existsByEmail(email);

    }

    public User  saveUser(User user){
        return userRepository.save(user);
    }
}
