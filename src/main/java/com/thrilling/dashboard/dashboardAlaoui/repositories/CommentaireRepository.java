package com.thrilling.dashboard.dashboardAlaoui.repositories;

import com.thrilling.dashboard.dashboardAlaoui.entities.Article;
import com.thrilling.dashboard.dashboardAlaoui.entities.Commentaire;
import com.thrilling.dashboard.dashboardAlaoui.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface CommentaireRepository extends JpaRepository<Commentaire,Integer> {
    long countByUser(User user);
    long countByArticle(Article article);

    List<Commentaire> findAllByArticle(Article article);

    @Query("select count(c) from Commentaire c")
    long countFirstBy();

}
