package com.mustache.bbs.controller;

import com.mustache.bbs.domain.dto.ArticleDto;
import com.mustache.bbs.domain.entity.Article;
import com.mustache.bbs.repository.ArticleReapository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/articles")
public class ArticleController {
    private final ArticleReapository articleReapository;

    public ArticleController(ArticleReapository articleReapository) {
        this.articleReapository = articleReapository;
    }

    @GetMapping(value = "/new")
    public String formPage(){
        return "articles/new";
    }
    @PostMapping("")
    public String createArticle(ArticleDto articleDto){
        Article article = articleDto.toEntity();

        Article saved = articleReapository.save(article);
        return String.format("redirect:/articles/%d",saved.getId());
    }
}
