package Application.Repository;

import Application.Model.Account;
import Application.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by gwlodarczyk on 2017-04-26.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>, QueryDslPredicateExecutor<Account> {

    @Query("SELECT p.role FROM Account p WHERE p.role.role = :name")
    Role findRoleByName(@Param("name") String name);
}
