package com.thrilling.dashboard.dashboardAlaoui.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ListedComment {

    private Integer id;

    private String body;

    private int likes;

    private String username;

    private String article;

    private boolean visibility;

    private Date updated_at;
}
