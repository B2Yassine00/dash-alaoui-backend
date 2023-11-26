package com.thrilling.dashboard.dashboardAlaoui.repositories;

import com.thrilling.dashboard.dashboardAlaoui.entities.Article;
import com.thrilling.dashboard.dashboardAlaoui.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    @Query("select count(a) from Article a")
    long countFirstBy();

}
