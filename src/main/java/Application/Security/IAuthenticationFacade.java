package Application.Security;

import org.springframework.security.core.Authentication;

public interface IAuthenticationFacade {
  public Authentication getAuthentication();

  public Roles getRole();
}
