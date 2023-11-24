package com.thrilling.dashboard.dashboardAlaoui.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class PostedComment {

    private Integer article_id;
    private String first_name;
    private String last_name;
    private String email;
    private String body;

}
