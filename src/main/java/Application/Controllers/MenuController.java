package Application.Controllers;

import Application.Security.AuthenticationFacade;
import Application.Security.Context;
import Application.Security.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MenuController {

  @Autowired
  private AuthenticationFacade auth;

  @Autowired
  private Context context;

  @RequestMapping("/menu")
  public List<String> getMenuOptions(){

    String roleContext = context.getRole();
    Roles role = Roles.roleOf(roleContext);

    switch (role) {
      case DOCTOR: {
        return Arrays.asList("start", "karta-pacjenta", "wizyty","dostepnosc");
      }
      case EMPLOYEE: {
        return Arrays.asList("start");
      }
      case PATIENT: {
        return Arrays.asList("start", "umow-wizyte");
      }
      case ADMIN: {
        return Arrays.asList("start", "panel-admina", "edycja-kont");
      }
      default: {
        return Arrays.asList("start","o nas", "rejestracja");
      }
    }
  }
}
