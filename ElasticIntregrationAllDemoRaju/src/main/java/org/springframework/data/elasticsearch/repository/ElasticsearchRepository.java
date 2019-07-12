package org.springframework.data.elasticsearch.repository;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ElasticsearchRepository<T, ID> extends ElasticsearchCrudRepository<T, ID> {

    <S extends T> S index(S entity);

    /**
     * This method is intended to be used when many single inserts must be made
     * that cannot be aggregated to be inserted with {@link #saveAll(Iterable)}.
     * This might lead to a temporary inconsistent state until
     * {@link #refresh()} is called.
     */
    <S extends T> S indexWithoutRefresh(S entity);

    Iterable<T> search(QueryBuilder query);

    Page<T> search(QueryBuilder query, Pageable pageable);

    Page<T> search(SearchQuery searchQuery);

    Page<T> searchSimilar(T entity, String[] fields, Pageable pageable);

    void refresh();

    Class<T> getEntityClass();
}
