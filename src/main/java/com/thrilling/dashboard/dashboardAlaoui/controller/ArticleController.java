package com.thrilling.dashboard.dashboardAlaoui.controller;

import com.thrilling.dashboard.dashboardAlaoui.DTO.PostedArticle;
import com.thrilling.dashboard.dashboardAlaoui.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/article")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class ArticleController {

    @Autowired
    ArticleService service;
    @PostMapping("/post-article")
    public String postArticle(@RequestBody PostedArticle article){
        service.saveArticle(article);
        return "the article : "+article.getTitle()+" is saved";
    }
}
