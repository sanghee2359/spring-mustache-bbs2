package com.mustache.bbs.domain.entity;


import com.mustache.bbs.domain.dto.ArticleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="article4")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    public static ArticleDto of(Article article){
        return new ArticleDto(article.getId(), article.getTitle(), article.getContent());
    }
}


