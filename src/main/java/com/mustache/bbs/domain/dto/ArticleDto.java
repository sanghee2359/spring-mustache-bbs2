package com.mustache.bbs.domain.dto;

import com.mustache.bbs.domain.entity.Article;
import lombok.*;


@Getter
@ToString
@NoArgsConstructor
@Builder
public class ArticleDto {
    private Long id;
    private String content;
    private String title;

    public ArticleDto(Long id, String content, String title) {
        this.id = id;
        this.content = content;
        this.title = title;
    }
    public Article toEntity() {
        return new Article(this.id, this.title, this.content);
    }
}
