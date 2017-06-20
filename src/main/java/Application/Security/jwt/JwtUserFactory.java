package Application.Security.jwt;

import Application.Model.Account;
import Application.Model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.List;

public final class JwtUserFactory {

  private JwtUserFactory() {
  }

  public static JwtUser create(Account user) {
    return new JwtUser(
      user.getId(),
      user.getUsername(),
      user.getPassword(),
      mapToGrantedAuthorities(user.getRole())

    );
  }

  private static List<GrantedAuthority> mapToGrantedAuthorities(Role role) {
    return Arrays.asList(new SimpleGrantedAuthority(role.getRole()));
  }
}
