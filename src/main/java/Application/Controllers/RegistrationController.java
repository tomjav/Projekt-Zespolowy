package Application.Controllers;

import Application.DTOs.RegisterDTO;
import Application.Model.UserType;
import Application.Services.Interfaces.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "register")
public class RegistrationController {

  @Autowired
  private RegisterService registerService;

  @RequestMapping(method = RequestMethod.POST)
  public void registerUser(@RequestParam UserType userType, @RequestBody RegisterDTO registerDTO){

    if(userType.equals(UserType.PATIENT))
      registerService.registerPatient(registerDTO);
    else
    if(userType.equals(UserType.EMPLOYEE))
      registerService.registerEmployee(registerDTO);
    else
      throw new IllegalArgumentException();
  }

}
