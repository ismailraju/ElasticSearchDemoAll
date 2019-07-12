/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raju.elasticsearch.service;

import com.raju.elasticsearch.dao.PrisonerDao;
import com.raju.elasticsearch.dao.PrisonerDaoImp;
import com.raju.elasticsearch.entity.Prisoner;

/**
 *
 * @author Raju
 */
public class PrisonerService {

    public static void main(String[] args) {

        System.out.println("Inserting a new Prisoner with name Shubham...");
        Prisoner prisoner = new Prisoner();
        prisoner.setFullNameEn("tq");
        PrisonerDao prisonerDao = new PrisonerDaoImp();
        prisoner = prisonerDao.create(prisoner);
        System.out.println("Prisoner inserted --> " + prisoner);

//        System.out.println("Changing name to `Shubham Aggarwal`...");
//        prisoner.setFullNameEn("Shubham Aggarwal");
//        prisonerDao.update(prisoner.getPrisonerNo(), prisoner);
//        System.out.println("Prisoner updated  --> " + prisoner);
//
//        System.out.println("Getting Shubham...");
//        Prisoner prisonerFromDB = prisonerDao.getPrisonerById(prisoner.getPrisonerNo());
//        System.out.println("Prisoner from DB  --> " + prisonerFromDB);
//
//        System.out.println("Deleting Shubham...");
//        prisonerDao.delete(prisonerFromDB.getPrisonerNo());
//        System.out.println("Prisoner Deleted");

    }
}
