package Application.Repository;

import Application.Model.Employee;
import Application.Model.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by gwlodarczyk on 2017-04-26.
 */
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>, QueryDslPredicateExecutor<Employee> {

  @Query(value = "SELECT p FROM Employee p WHERE p.account.id = :id")
  Employee findByAccountId(@Param("id") Long id);

  @Query(value = "SELECT p.id FROM Employee p WHERE p.name = :name AND p.surname = :surname")
  Long findByNameAndSurname(@Param("name") String name,@Param("surname") String surname);
}
