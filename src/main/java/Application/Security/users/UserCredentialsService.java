package Application.Security.users;

import Application.Model.Account;
import Application.Security.jwt.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
* Ten bean jest automatycznie wstrzykiwany do Spring OAuth poprzez interfejs
* */
@Service
public class UserCredentialsService implements UserDetailsService {

  @Autowired
  private UserCredentialsRepository userRepo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Account user = userRepo.findByUsername(username);
    return JwtUserFactory.create(user);
  }
}
