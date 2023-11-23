package com.thrilling.dashboard.dashboardAlaoui.services;

import com.thrilling.dashboard.dashboardAlaoui.DTO.ListedComment;
import com.thrilling.dashboard.dashboardAlaoui.entities.Commentaire;
import com.thrilling.dashboard.dashboardAlaoui.repositories.ArticleRepository;
import com.thrilling.dashboard.dashboardAlaoui.repositories.CommentaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    @Autowired
    private ArticleRepository repository;

    @Autowired
    private CommentaireRepository commentaireRepository;

    public List<ListedComment> listedComments(){
        List<Commentaire> comments = commentaireRepository.findAll();
        List<ListedComment> listedComments = new ArrayList<>();
        for (Commentaire commentaire:comments){
            ListedComment tempComment =new ListedComment(commentaire.getId(),commentaire.getBody(),commentaire.getLikes(),commentaire.getUser().getFirstName()+" "+commentaire.getUser().getLastName(),commentaire.getArticle().getTitle(),commentaire.isVisibility(),commentaire.getUpdated_at());
            listedComments.add(tempComment);
        }
        return listedComments;
    }
}
