package com.thrilling.dashboard.dashboardAlaoui.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ListedArticle {

    private Integer id;
    private String title;
    private int likes;
    private Long comments;
    private boolean visibility;
    private Date updated_at;
}
