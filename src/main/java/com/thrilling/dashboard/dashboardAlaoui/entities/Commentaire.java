package com.thrilling.dashboard.dashboardAlaoui.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "body")
    private String body;

    @Column(name = "likes")
    private int likes;

    @ManyToOne
    @JoinColumn(name = "article_id",nullable = false)
    private Article article;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @Column(name = "date_creation")
    @CreationTimestamp
    private Date created_at;

    @Column(name = "date_modification")
    @UpdateTimestamp
    private Date updated_at;
}
