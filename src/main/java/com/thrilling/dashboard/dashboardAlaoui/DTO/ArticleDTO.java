package com.thrilling.dashboard.dashboardAlaoui.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ArticleDTO {

    private Integer id;
    private String title;
    private String body;
    private int likes;
    private boolean visibility;
    private Date created_at;
    private Date updated_at;

}
