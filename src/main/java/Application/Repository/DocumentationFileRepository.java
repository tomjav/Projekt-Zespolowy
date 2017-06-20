package Application.Repository;

import Application.Model.DocumentationFile;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gwlodarczyk on 2017-04-26.
 */
@Repository
public interface DocumentationFileRepository extends PagingAndSortingRepository<DocumentationFile, Long>, QueryDslPredicateExecutor<DocumentationFile> {
}
