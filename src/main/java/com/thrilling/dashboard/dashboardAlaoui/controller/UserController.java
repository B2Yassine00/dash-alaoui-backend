package com.thrilling.dashboard.dashboardAlaoui.controller;

import com.thrilling.dashboard.dashboardAlaoui.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
