package com.blog.services;

import com.blog.models.Entities.Article;
import com.blog.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public void setArticleRepository(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Iterable<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticleById(Integer id) {
        return articleRepository.findOne(id);
    }

    @Override
    public Article insertArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Integer id) {
        articleRepository.delete(id);
    }
}
