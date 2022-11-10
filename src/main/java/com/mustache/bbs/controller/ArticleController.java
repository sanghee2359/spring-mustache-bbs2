package com.mustache.bbs.controller;

import com.mustache.bbs.domain.dto.ArticleDto;
import com.mustache.bbs.domain.entity.Article;
import com.mustache.bbs.repository.ArticleReapository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping(value = "/articles")
public class ArticleController {
    private final ArticleReapository articleReapository;

    public ArticleController(ArticleReapository articleReapository) {
        this.articleReapository = articleReapository;
    }

    @GetMapping(value = "/new")
    public String formPage(){
        return "new";
    }
    @PostMapping("")
    public String createArticle(ArticleDto articleDto){
        Article article = articleDto.toEntity();

        Article saved = articleReapository.save(article);
        return String.format("redirect:/articles/%d",saved.getId());
    }
    @GetMapping(value="/{id}")
    public String getArticle(@PathVariable Long id, Model model){
        Optional<Article> optArticle = articleReapository.findById(id);
        if(!optArticle.isEmpty()){
            model.addAttribute("article",optArticle.get());
            return "show";
        }else return "error";
    }
    @GetMapping(value = "/list")
    public String list(Model model){
        PageRequest pageRequest = PageRequest.of(0, 100);
        Page<Article> articles = articleReapository.findAll(pageRequest);
        model.addAttribute("articles",articles);
        return "list";
    }
    @GetMapping(value="")
    public String index(){
        return "redirect:/articles/list";
    }
}
