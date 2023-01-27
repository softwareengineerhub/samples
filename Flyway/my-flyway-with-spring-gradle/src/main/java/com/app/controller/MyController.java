package com.app.controller;

import com.app.model.Article;
import com.app.service.ArticleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class MyController {

  @Autowired
  private ArticleService articleService;

  @GetMapping
  public List<Article> getAll() {
    return articleService.findAll();
  }

  @GetMapping("/title/{title}")
  public List<Article> getAll(@PathVariable String title) {
    return articleService.findByTitle(title);
  }

  @GetMapping("/count")
  public long getCount() {
    return articleService.count();
  }

}
