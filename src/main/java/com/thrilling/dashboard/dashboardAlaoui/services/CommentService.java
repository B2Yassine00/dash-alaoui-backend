package com.thrilling.dashboard.dashboardAlaoui.services;

import com.thrilling.dashboard.dashboardAlaoui.DTO.CommentDTO;
import com.thrilling.dashboard.dashboardAlaoui.DTO.ListedComment;
import com.thrilling.dashboard.dashboardAlaoui.DTO.PostedComment;
import com.thrilling.dashboard.dashboardAlaoui.entities.Article;
import com.thrilling.dashboard.dashboardAlaoui.entities.Commentaire;
import com.thrilling.dashboard.dashboardAlaoui.entities.User;
import com.thrilling.dashboard.dashboardAlaoui.repositories.ArticleRepository;
import com.thrilling.dashboard.dashboardAlaoui.repositories.CommentaireRepository;
import com.thrilling.dashboard.dashboardAlaoui.repositories.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    public long totalComment(){
        return commentaireRepository.countFirstBy();
    }

    public List<ListedComment> listedComments(){
        List<Commentaire> comments = commentaireRepository.findAll();
        List<ListedComment> listedComments = new ArrayList<>();
        for (Commentaire commentaire:comments){
            ListedComment tempComment =new ListedComment(commentaire.getId(),commentaire.getBody(),commentaire.getLikes(),commentaire.getUser().getFirstName()+" "+commentaire.getUser().getLastName(),commentaire.getArticle().getTitle(),commentaire.isVisibility(),commentaire.getUpdated_at());
            listedComments.add(tempComment);
        }
        return listedComments;
    }

    public List<CommentDTO> listCommentByArticle(Article article){
        List<Commentaire> commentaires = commentaireRepository.findAllByArticle(article);
        List<CommentDTO> comments = new ArrayList<>();
        for (Commentaire commentaire:commentaires){
            CommentDTO commentDTO = new CommentDTO(commentaire.getId(),commentaire.getArticle().getId(),commentaire.getUser().getFirstName(),commentaire.getUser().getLastName(),commentaire.getUser().getEmail(), commentaire.getBody(), commentaire.isVisibility(),commentaire.getCreated_at());
            comments.add(commentDTO);
        }
        return comments;
    }

    public Commentaire postComment(PostedComment postedComment){
        if (!userRepository.existsByEmail(postedComment.getEmail())){
            User userito = new User();
            userito.setEmail(postedComment.getEmail());
            userito.setFirstName(postedComment.getFirst_name());
            userito.setLastName(postedComment.getLast_name());
            User user = userRepository.save(userito);
            Commentaire commentaire = new Commentaire();
            Article article = repository.findById(postedComment.getArticle_id()).get();
            commentaire.setArticle(article);
            commentaire.setBody(postedComment.getBody());
            commentaire.setUser(user);
            commentaire.setLikes(0);
            commentaire.setVisibility(postedComment.getActive());
            return commentaireRepository.save(commentaire);
        }else {
            User userito = userRepository.findByEmail(postedComment.getEmail()).get();
            Commentaire commentaire = new Commentaire();
            Article article = repository.findById(postedComment.getArticle_id()).get();
            commentaire.setArticle(article);
            commentaire.setBody(postedComment.getBody());
            commentaire.setUser(userito);
            commentaire.setLikes(0);
            return commentaireRepository.save(commentaire);
        }
    }

    public String hideComment(Integer id){
        Commentaire commentaire = commentaireRepository.findById(id).get();
        commentaire.setVisibility(false);
        commentaireRepository.save(commentaire);
        return "le commentaire :"+commentaire.getBody()+" est caché";
    }

    public String showComment(Integer id){
        Commentaire commentaire = commentaireRepository.findById(id).get();
        commentaire.setVisibility(true);
        commentaireRepository.save(commentaire);
        System.out.println("le commentaire :"+commentaire.getBody()+" est validé");
        return "le commentaire :"+commentaire.getBody()+" est validé";
    }
}
