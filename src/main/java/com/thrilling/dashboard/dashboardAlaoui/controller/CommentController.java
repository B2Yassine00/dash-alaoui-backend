package com.thrilling.dashboard.dashboardAlaoui.controller;

import com.thrilling.dashboard.dashboardAlaoui.DTO.ListedComment;
import com.thrilling.dashboard.dashboardAlaoui.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/comment")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @GetMapping("/list-comments")
    public List<ListedComment> listComments(){

        return commentService.listedComments();
    }
}
