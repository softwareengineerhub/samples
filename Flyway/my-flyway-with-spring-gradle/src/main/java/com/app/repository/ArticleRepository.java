package com.app.repository;

import com.app.model.Article;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {

  public List<Article> findByTitle(String title);

}
