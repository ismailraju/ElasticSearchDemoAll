package com.raju.elasticsearch.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.raju.elasticsearch.config.ElasticSearchConfigaration;
import com.raju.elasticsearch.entity.Prisoner;
import com.raju.elasticsearch.entity.Prisoner;
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

public class PrisonerDaoImp implements PrisonerDao {

    public List<Prisoner> getPrisonerList(Integer p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Prisoner update(String id, Prisoner prisoner) {
        UpdateRequest updateRequest = new UpdateRequest(ElasticSearchConfigaration.INDEX, ElasticSearchConfigaration.TYPE, id)
                .fetchSource(true);    // Fetch Object after its update
        try {
            String prisonerJson = ElasticSearchConfigaration.objectMapper.writeValueAsString(prisoner);
            updateRequest.doc(prisonerJson, XContentType.JSON);
            UpdateResponse updateResponse = ElasticSearchConfigaration.getRestHighLevelClient().update(updateRequest);
            return ElasticSearchConfigaration.objectMapper.convertValue(updateResponse.getGetResult().sourceAsMap(), Prisoner.class);
        } catch (JsonProcessingException e) {
            e.getMessage();
        } catch (java.io.IOException e) {
            e.getLocalizedMessage();
        }
        System.out.println("Unable to update prisoner");
        return null;
    }

    public Prisoner create(Prisoner prisoner) {
        prisoner.setPrisonerNo(UUID.randomUUID().toString());
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("prisonerNo", prisoner.getPrisonerNo());
        dataMap.put("firstNameEn", prisoner.getFirstNameEn());
        IndexRequest indexRequest = new IndexRequest(ElasticSearchConfigaration.INDEX, ElasticSearchConfigaration.TYPE, prisoner.getPrisonerNo())
                .source(dataMap);
        try {
            IndexResponse response = ElasticSearchConfigaration.getRestHighLevelClient().index(indexRequest);
//            ElasticSearchConfigaration.closeConnection();
        } catch (ElasticsearchException e) {
            e.getDetailedMessage();
        } catch (java.io.IOException ex) {
            ex.getLocalizedMessage();
        }
        return prisoner;
    }

    public void delete(String id) {
        DeleteRequest deleteRequest = new DeleteRequest(ElasticSearchConfigaration.INDEX, ElasticSearchConfigaration.TYPE, id);
        try {
            DeleteResponse deleteResponse = ElasticSearchConfigaration.getRestHighLevelClient().delete(deleteRequest);
        } catch (java.io.IOException e) {
            e.getLocalizedMessage();
        }
    }

    public Prisoner getPrisonerById(String id) {
        GetRequest getPrisonerRequest = new GetRequest(ElasticSearchConfigaration.INDEX, ElasticSearchConfigaration.TYPE, id);
        GetResponse getResponse = null;
        try {
            getResponse = ElasticSearchConfigaration.getRestHighLevelClient().get(getPrisonerRequest);
        } catch (java.io.IOException e) {
            e.getLocalizedMessage();
        }
        return getResponse != null
                ? ElasticSearchConfigaration.objectMapper.convertValue(getResponse.getSourceAsMap(), Prisoner.class) : null;
    }

}
