package Application.Security;

import Application.Security.jwt.JwtUser;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class Contextimpl implements Context{


  public Long getUserId() {
    JwtUser principal = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return principal.getId();
  }

  public String getUsername() {
    JwtUser principal = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return principal.getUsername();
  }

  public String getRole() {
    SecurityContext context = SecurityContextHolder.getContext();
    return context.getAuthentication().getAuthorities().stream().findFirst().get().getAuthority();
  }

}
