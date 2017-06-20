package Application.Controllers;

import Application.DTOs.DocumentationDTO;
import Application.Model.Patient;
import Application.Repository.PatientRepository;
import Application.Services.Interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by gwlodarczyk on 28.04.2017.
 */
@RestController
@RequestMapping(value = "/patient")
public class PatientController {

  @Autowired
  private PatientService patientService;

  @Autowired
  private PatientRepository patientRepository;

  @RequestMapping(value = "/list/all", method = RequestMethod.GET)
  public List<Patient> getPatients() {
    return patientService.getFullListOfPatients();
  }

  @RequestMapping(value = "/documentation/{id}", method = RequestMethod.GET)
  public List<DocumentationDTO> getFullPatientDocumentation(@PathVariable("id") String patientId) {
    return patientService.getFullPatientDocumentation(patientId);
  }

  @RequestMapping(method = RequestMethod.GET)
  public Long getAppointmentForEmployee(@RequestParam String name, @RequestParam String surname){
    return patientRepository.findByNameAndSurname(name,surname);
  }

}
