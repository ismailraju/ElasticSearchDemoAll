/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baeldung.spring.data.es.dao;

import com.baeldung.spring.data.es.model.Article;
import java.util.List;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Raju
 */
@Repository
public class ArticleDaoImp implements ArticleDao {
//    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Value("${elasticsearch.index.name:blog}")
    private String indexName;
    @Value("${elasticsearch.user.type:article}")
    private String userTypeName;
    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Override
    public List<Article> getAllUsers() {
        System.out.println("getAllUsers");
        SearchQuery getAllQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchAllQuery()).build();
        return esTemplate.queryForList(getAllQuery, Article.class);
    }
    // Other methods
}
