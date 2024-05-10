package com.example.helloworld.controller;


import org.springframework.web.bind.annotation.*;

import com.example.helloworld.model.Article;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private static final Map<String, Article> articleMap = new HashMap<>();

    @GetMapping
    public List<Article> getAllArticles() {
        return new ArrayList<>(articleMap.values());
    }

    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        articleMap.put(article.getId(), article);
        return article;
    }

    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable String id, @RequestBody Article article) {
        article.setId(id);
        articleMap.put(id, article);
        return article;
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable String id) {
        articleMap.remove(id);
    }
}
