package com.thrilling.dashboard.dashboardAlaoui.services;

import com.thrilling.dashboard.dashboardAlaoui.DTO.ListedUser;
import com.thrilling.dashboard.dashboardAlaoui.entities.User;
import com.thrilling.dashboard.dashboardAlaoui.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<ListedUser> listUser(){
        List<User> userList = userRepository.findAll();
        List<ListedUser> listedUsers = new ArrayList<>();
        for (User user:userList){
            listedUsers.add(new ListedUser(user.getId(),user.getFirstName(),user.getLastName(),user.getEmail()));
        }
        return listedUsers;
    }

    public String deleteUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return "The User :" + user.get().getFirstName() + " " + user.get().getLastName() + " is deleted";
        }
        return " not found";
    }
}
