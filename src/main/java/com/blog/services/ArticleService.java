package com.blog.services;

import com.blog.models.Entities.Article;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService {

    Iterable<Article> getAllArticles();

    Article getArticleById(Integer id);

    Article insertArticle(Article article);

    void deleteArticle(Integer id);
}
