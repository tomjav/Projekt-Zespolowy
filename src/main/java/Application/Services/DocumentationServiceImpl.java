package Application.Services;

import Application.DTOs.DocumentationToEdit;
import Application.DTOs.DocumentationToSave;
import Application.Model.*;
import Application.Repository.DocumentationRepository;
import Application.Repository.EmployeeRepository;
import Application.Repository.PatientRepository;
import Application.Services.Interfaces.DocumentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author gwlodarczyk
 */
@Service
@Transactional
public class DocumentationServiceImpl implements DocumentationService {

  @Autowired
  private DocumentationRepository documentationRepository;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private PatientRepository patientRepository;

  @Override
  public Documentation editDocumentation(Documentation documentation, DocumentationToEdit documentationToEdit) {
    documentation.setTitle(documentationToEdit.getTitle());
    documentation.setText(documentationToEdit.getText());
    documentation.setTimeOfInscription(documentationToEdit.getTimeOfInscription());

    Employee employee = employeeRepository.findOne(QEmployee.employee.id.eq(documentationToEdit.getEmployeeId()));
    documentation.setEmployee(employee);

    return documentationRepository.save(documentation);
  }

  @Override
  public Documentation saveDocumentation(DocumentationToSave documentation) {
    Documentation newDocumentation = new Documentation();
    Patient patient = patientRepository.findOne(QPatient.patient.id.eq(documentation.getPatientId()));
    Employee employee = employeeRepository.findOne(QEmployee.employee.id.eq(documentation.getEmployeeId()));

    newDocumentation.setEmployee(employee);
    newDocumentation.setPatient(patient);
    newDocumentation.setText(documentation.getText());
    newDocumentation.setTitle(documentation.getTitle());
    newDocumentation.setTimeOfInscription(documentation.getTimeOfInscription());

    return documentationRepository.save(newDocumentation);
  }
}
