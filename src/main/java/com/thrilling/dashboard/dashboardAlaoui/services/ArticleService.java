package com.thrilling.dashboard.dashboardAlaoui.services;

import com.thrilling.dashboard.dashboardAlaoui.DTO.ListedArticle;
import com.thrilling.dashboard.dashboardAlaoui.DTO.PostedArticle;
import com.thrilling.dashboard.dashboardAlaoui.entities.Article;
import com.thrilling.dashboard.dashboardAlaoui.repositories.ArticleRepository;
import com.thrilling.dashboard.dashboardAlaoui.repositories.CommentaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    @Autowired
    private ArticleRepository repository;

    @Autowired
    private CommentaireRepository commentaireRepository;

    public long totalArticle(){
        return repository.countFirstBy();
    }

    public Article saveArticle(PostedArticle article){
        Article article1 = new Article();
        article1.setTitle(article.getTitle());
        article1.setBody(article.getBody());
        article1.setLikes(0);
        article1.setVisibility(true);

        return repository.save(article1);
    }

    public Article findArticleById(Integer id){
        if(repository.findById(id).isPresent()){
            return repository.findById(id).get();
        }
        throw new RuntimeException("Not Found");
    }
    public List<ListedArticle> listerArticle(){
        List<Article> articles = repository.findAll();
        List<ListedArticle> listedArticles = new ArrayList<>();
        for (Article article:articles){
            ListedArticle listedArticle = new ListedArticle(article.getId(),article.getTitle(),article.getLikes(),commentaireRepository.countByArticle(article),article.isVisibility(),article.getUpdated_at());
            listedArticles.add(listedArticle);
        }
        return listedArticles;
    }
}
