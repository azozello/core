package com.blog.controllers;

import com.blog.models.Entities.Article;
import com.blog.models.Entities.User;
import com.blog.services.Interfaces.ArticleService;
import com.blog.services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private UserService userService;
    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/restusers")
    public Iterable<User> users(){
        return userService.getAllUsers();
    }

    @RequestMapping("/restarticles")
    public Iterable<Article> articles(){
        return articleService.getAllArticles();
    }
}
