/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baeldung.spring.data.es.dao;

import com.baeldung.spring.data.es.model.Article;
import java.util.List;

/**
 *
 * @author Raju
 */

 
public abstract  interface   ArticleDao {
    
    public abstract List<Article> getAllUsers() ;
}
