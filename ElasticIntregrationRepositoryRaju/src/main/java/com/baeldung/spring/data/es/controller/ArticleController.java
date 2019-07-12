/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baeldung.spring.data.es.controller;

import com.baeldung.spring.data.es.model.Article;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.baeldung.spring.data.es.dao.ArticleDao;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Raju
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleDao userDAO;

 
    @RequestMapping(value = "all", method = RequestMethod.GET)
    @ResponseBody
    public List<Article> getAllUsers() {
        return userDAO.getAllUsers();
    }

//    @RequestMapping(value = "/new", method = RequestMethod.POST)
//    public Article addUsers(@RequestBody Article user) {
//        userDAO.addNewUser(user);
//        return user;
//    }
 
}
