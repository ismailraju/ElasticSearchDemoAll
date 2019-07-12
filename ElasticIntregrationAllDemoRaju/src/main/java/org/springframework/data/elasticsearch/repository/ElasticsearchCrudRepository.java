package org.springframework.data.elasticsearch.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface ElasticsearchCrudRepository<T, ID> extends PagingAndSortingRepository<T, ID> {

}
