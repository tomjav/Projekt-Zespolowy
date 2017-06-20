package Application.Services.Interfaces;

import Application.DTOs.DocumentationDTO;
import Application.Model.Patient;

import java.util.List;

/**
 * Created by gwlodarczyk on 29.04.2017.
 */

public interface PatientService {

  List<Patient> getFullListOfPatients();

  List<DocumentationDTO> getFullPatientDocumentation(String patientId);
}
