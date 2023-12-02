package com.thrilling.dashboard.dashboardAlaoui.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ListedUser {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}
