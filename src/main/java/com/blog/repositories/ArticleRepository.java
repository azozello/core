package com.blog.repositories;

import com.blog.models.Entities.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
}
