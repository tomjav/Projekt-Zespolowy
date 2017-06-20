package Application.Repository;

import Application.Model.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gwlodarczyk on 2017-04-26.
 */
@Repository
public interface AppointmentRepository extends PagingAndSortingRepository<Appointment, Long>, QueryDslPredicateExecutor<Appointment> {

    @Query(value = "SELECT p FROM Appointment p WHERE p.employee.id = :id AND p.patient is null")
    List<Appointment> findAppointmentForEmployee(@Param(value = "id") Long id);

    @Query(value = "SELECT p FROM Appointment p WHERE p.employee.id = :id AND p.patient is not null")
    List<Appointment> findAppointmentForEmployeeWithPatient(@Param(value = "id") Long id);
}
