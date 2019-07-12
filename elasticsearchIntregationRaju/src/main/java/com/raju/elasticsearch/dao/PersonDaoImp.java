package com.raju.elasticsearch.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.raju.elasticsearch.config.ElasticSearchConfigaration;
import com.raju.elasticsearch.entity.Person;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.common.xcontent.XContentType;

public class PersonDaoImp implements PersonDao {

    public List<Person> getPersonList(Integer p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Person update(String id, Person person) {
        UpdateRequest updateRequest = new UpdateRequest(ElasticSearchConfigaration.INDEX, ElasticSearchConfigaration.TYPE, id)
                .fetchSource(true);    // Fetch Object after its update
        try {
            String personJson = ElasticSearchConfigaration.objectMapper.writeValueAsString(person);
            updateRequest.doc(personJson, XContentType.JSON);
            UpdateResponse updateResponse = ElasticSearchConfigaration.getRestHighLevelClient().update(updateRequest);
            return ElasticSearchConfigaration.objectMapper.convertValue(updateResponse.getGetResult().sourceAsMap(), Person.class);
        } catch (JsonProcessingException e) {
            e.getMessage();
        } catch (java.io.IOException e) {
            e.getLocalizedMessage();
        }
        System.out.println("Unable to update person");
        return null;
    }

    public Person create(Person person) {
        person.setPersonId(UUID.randomUUID().toString());
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("personId", person.getPersonId());
        dataMap.put("name", person.getName());
        IndexRequest indexRequest = new IndexRequest(ElasticSearchConfigaration.INDEX, ElasticSearchConfigaration.TYPE, person.getPersonId())
                .source(dataMap);
        try {
            IndexResponse response = ElasticSearchConfigaration.getRestHighLevelClient().index(indexRequest);
//            ElasticSearchConfigaration.closeConnection();
        } catch (ElasticsearchException e) {
            e.getDetailedMessage();
        } catch (java.io.IOException ex) {
            ex.getLocalizedMessage();
        }
        return person;
    }

    public void delete(String id) {
        DeleteRequest deleteRequest = new DeleteRequest(ElasticSearchConfigaration.INDEX, ElasticSearchConfigaration.TYPE, id);
        try {
            DeleteResponse deleteResponse = ElasticSearchConfigaration.getRestHighLevelClient().delete(deleteRequest);
        } catch (java.io.IOException e) {
            e.getLocalizedMessage();
        }
    }

    public Person getPersonById(String id) {
        GetRequest getPersonRequest = new GetRequest(ElasticSearchConfigaration.INDEX, ElasticSearchConfigaration.TYPE, id);
        GetResponse getResponse = null;
        try {
            getResponse = ElasticSearchConfigaration.getRestHighLevelClient().get(getPersonRequest);
        } catch (java.io.IOException e) {
            e.getLocalizedMessage();
        }
        return getResponse != null
                ? ElasticSearchConfigaration.objectMapper.convertValue(getResponse.getSourceAsMap(), Person.class) : null;
    }

}
