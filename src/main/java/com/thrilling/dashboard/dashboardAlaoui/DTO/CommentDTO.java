package com.thrilling.dashboard.dashboardAlaoui.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CommentDTO {

    private Integer comment_id;
    private Integer article_id;
    private String first_name;
    private String last_name;
    private String email;
    private String body;
    private Boolean active;
    private Date updated_at;

}
