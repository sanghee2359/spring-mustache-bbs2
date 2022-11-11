package com.mustache.bbs.domain.dto;

import com.mustache.bbs.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@AllArgsConstructor

public class ArticleDto {
    private Long id;
    private String content;
    private String title;

    public Article toEntity() {
        return new Article(this.id, this.title, this.content);
    }
}
