package Application.Security.users;

import Application.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsRepository extends JpaRepository<Account, Long> {
  Account findByUsername(String username);
}
