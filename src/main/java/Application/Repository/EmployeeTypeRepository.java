package Application.Repository;

import Application.Model.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by gwlodarczyk on 2017-04-26.
 */
@Repository
public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Long>, QueryDslPredicateExecutor<EmployeeType> {

  @Query(value = "SELECT p from EmployeeType p where p.title = :title")
  EmployeeType findByTitle(@Param(value = "title") String title);
}
