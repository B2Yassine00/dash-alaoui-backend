package com.thrilling.dashboard.dashboardAlaoui.controller;

import com.thrilling.dashboard.dashboardAlaoui.DTO.ListedUser;
import com.thrilling.dashboard.dashboardAlaoui.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/total-user")
    public long totalArticle(){
        return service.totalUser();
    }

    @GetMapping("/all-users")
    public List<ListedUser> listUsers(){
        return service.listUser();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id){
        return service.deleteUser(id);
    }

}
