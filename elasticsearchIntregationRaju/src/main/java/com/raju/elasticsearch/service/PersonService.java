/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raju.elasticsearch.service;

import com.raju.elasticsearch.dao.PersonDao;
import com.raju.elasticsearch.dao.PersonDaoImp;
import com.raju.elasticsearch.entity.Person;

/**
 *
 * @author Raju
 */
public class PersonService {

    public static void main(String[] args) {
        System.out.println("Inserting a new Person with name Shubham...");
        Person person = new Person();
        person.setName("tq");
        PersonDao personDao = new PersonDaoImp();
        person = personDao.create(person);
        System.out.println("Person inserted --> " + person);

//        System.out.println("Changing name to `Shubham Aggarwal`...");
//        person.setName("Shubham Aggarwal");
//        personDao.update(person.getPersonId(), person);
//        System.out.println("Person updated  --> " + person);
//
//        System.out.println("Getting Shubham...");
//        Person personFromDB = personDao.getPersonById(person.getPersonId());
//        System.out.println("Person from DB  --> " + personFromDB);
//
//        System.out.println("Deleting Shubham...");
//        personDao.delete(personFromDB.getPersonId());
//        System.out.println("Person Deleted");

    }
}
