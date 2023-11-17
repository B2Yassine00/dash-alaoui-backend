package com.thrilling.dashboard.dashboardAlaoui.services;

import com.thrilling.dashboard.dashboardAlaoui.DTO.PostedArticle;
import com.thrilling.dashboard.dashboardAlaoui.entities.Article;
import com.thrilling.dashboard.dashboardAlaoui.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {

    @Autowired
    private ArticleRepository repository;

    public Article saveArticle(PostedArticle article){
        Article article1 = new Article();
        article1.setTitle(article.getTitle());
        article1.setBody(article.getBody());
        article1.setLikes(0);
        article1.setVisibility(true);

        return repository.save(article1);
    }
}
