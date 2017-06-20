package Application.Security.users;

import Application.Model.Employee;
import Application.Model.Patient;
import Application.Repository.EmployeeRepository;
import Application.Repository.PatientRepository;
import Application.Security.jwt.JwtTokenUtil;
import Application.Security.jwt.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
public class AccountController {

  @Value("${jwt.header}")
  private String tokenHeader;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private PatientRepository patientRepository;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private UserDetailsService userDetailsService;

  @RequestMapping(value = "user", method = RequestMethod.GET)
  public JwtUser getAuthenticatedUser(HttpServletRequest request) {
    Enumeration<String> headerNames = request.getHeaderNames();
    String token = request.getHeader(tokenHeader);
    String username = jwtTokenUtil.getUsernameFromToken(token);
    JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

    Patient patient = patientRepository.findByAccountId(user.getId());
    Employee employee = null;
    if (patient == null) {
      employee = employeeRepository.findByAccountId(user.getId());
      user.setLastname(employee.getSurname());
      user.setFirstname(employee.getName());
    } else {
      user.setFirstname(patient.getName());
      user.setLastname(patient.getSurname());
    }
    return user;
  }

}
