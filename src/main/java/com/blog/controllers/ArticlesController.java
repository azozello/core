package com.blog.controllers;

import com.blog.models.Entities.Article;
import com.blog.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArticlesController {

    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public String all(Model model){
        model.addAttribute("articles", articleService.getAllArticles());
        System.out.println("Loading all articles");
        return "articles";
    }

    @RequestMapping("article/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("article", articleService.getArticleById(id));
        return "articleshow";
    }

    @RequestMapping("article/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("article", articleService.getArticleById(id));
        return "articleform";
    }

    @RequestMapping("article/new")
    public String newProduct(Model model) {
        model.addAttribute("article", new Article());
        return "articleform";
    }

    @RequestMapping(value = "article", method = RequestMethod.POST)
    public String saveProduct(Article article) {
        articleService.insertArticle(article);
        return "redirect:/article/" + article.getId();
    }

    @RequestMapping("article/delete/{id}")
    public String delete(@PathVariable Integer id) {
        articleService.deleteArticle(id);
        return "redirect:/articles";
    }
}
