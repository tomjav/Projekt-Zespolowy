package Application.Repository;

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
public interface PatientRepository extends PagingAndSortingRepository<Patient, Long>, QueryDslPredicateExecutor<Patient> {

  @Query(value = "SELECT p FROM Patient p WHERE p.account.id = :id")
  Patient findByAccountId(@Param("id") Long id);

  @Query(value = "SELECT p.id FROM Patient p WHERE p.name = :name AND p.surname = :surname")
  Long findByNameAndSurname(@Param("name") String name,@Param("surname") String surname);
}
