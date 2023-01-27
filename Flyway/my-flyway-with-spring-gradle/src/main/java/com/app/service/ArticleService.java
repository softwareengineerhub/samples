package com.app.service;

import com.app.model.Article;
import com.app.repository.ArticleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

  @Autowired
  private ArticleRepository articleRepository;

  public List<Article> findAll() {
    return (List<Article>) articleRepository.findAll();
  }

  public long count() {
    return articleRepository.count();
  }

  public List<Article> findByTitle(String title) {
    return articleRepository.findByTitle(title);
  }

}
