
package org.springframework.data.elasticsearch.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;

/**
 * Elasticsearch specific {@link org.springframework.data.repository.Repository}
 * interface with reactive support.
 *
 * @author Christoph Strobl
 * @since 3.2
 */
@NoRepositoryBean
public interface ReactiveElasticsearchRepository<T, ID> extends ReactiveSortingRepository<T, ID> {

}
