package com.raju.elasticsearch.dao;

import com.raju.elasticsearch.entity.Person;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public abstract interface PersonDao {

    public abstract List<Person> getPersonList(Integer p);

    public abstract Person getPersonById(String p);

    public abstract Person update(String id, Person person);

    public abstract Person create(Person p);

    public abstract void delete(String id);

}
