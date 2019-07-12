package com.raju.elasticsearch.dao;

import com.raju.elasticsearch.entity.Prisoner;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public abstract interface PrisonerDao {

    public abstract List<Prisoner> getPrisonerList(Integer p);

    public abstract Prisoner getPrisonerById(String p);

    public abstract Prisoner update(String id, Prisoner prisoner);

    public abstract Prisoner create(Prisoner p);

    public abstract void delete(String id);
}
