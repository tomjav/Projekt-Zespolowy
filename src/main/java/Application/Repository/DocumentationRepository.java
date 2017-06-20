package Application.Repository;

import Application.Model.Documentation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gwlodarczyk on 2017-04-26.
 */
@Repository
public interface DocumentationRepository extends PagingAndSortingRepository<Documentation, Long>, QueryDslPredicateExecutor<Documentation> {
}
