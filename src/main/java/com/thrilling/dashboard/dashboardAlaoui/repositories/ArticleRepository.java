package com.thrilling.dashboard.dashboardAlaoui.repositories;

import com.thrilling.dashboard.dashboardAlaoui.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
