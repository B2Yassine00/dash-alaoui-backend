package com.thrilling.dashboard.dashboardAlaoui.controller;

import com.thrilling.dashboard.dashboardAlaoui.DTO.ListedComment;
import com.thrilling.dashboard.dashboardAlaoui.DTO.PostedComment;
import com.thrilling.dashboard.dashboardAlaoui.entities.Article;
import com.thrilling.dashboard.dashboardAlaoui.entities.Commentaire;
import com.thrilling.dashboard.dashboardAlaoui.services.ArticleService;
import com.thrilling.dashboard.dashboardAlaoui.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comment")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    @GetMapping("/list-comments")
    public List<ListedComment> listComments(){

        return commentService.listedComments();
    }

    @GetMapping("/list-comments-by-article/{id}")
    public List<Commentaire> listCommentsByArticle(@PathVariable Integer id){
        Article article = articleService.findArticleById(id);
        return commentService.listCommentByArticle(article);
    }

    @PostMapping("/post-comment")
    public String postComment(@RequestBody PostedComment postedComment){

        Commentaire commentaire =commentService.postComment(postedComment);

        return "the comment :"+ commentaire.getBody() + " of the article :"+commentaire.getArticle().getId()+" has been added from the user :"+commentaire.getUser().getFirstName()+" "+commentaire.getUser().getLastName();
    }
}
