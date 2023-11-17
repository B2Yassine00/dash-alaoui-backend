package com.thrilling.dashboard.dashboardAlaoui.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.proxy.HibernateProxy;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "article_id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "body", columnDefinition = "TEXT")
    private String body;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "article")
    private List<Commentaire> commentaires;

    @Column(name = "likes")
    private int likes;

    @Column(name = "visibility")
    private boolean visibility;

    @Column(name = "date_creation")
    @CreationTimestamp
    private Date created_at;

    @Column(name = "date_modification")
    @UpdateTimestamp
    private Date updated_at;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Article article = (Article) o;
        return getId() != null && Objects.equals(getId(), article.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
