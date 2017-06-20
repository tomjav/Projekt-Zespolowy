package Application.Services;

import Application.DTOs.DocumentationDTO;
import Application.Model.*;
import Application.Repository.DocumentationFileRepository;
import Application.Repository.DocumentationRepository;
import Application.Repository.PatientRepository;
import Application.Services.Interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gwlodarczyk on 29.04.2017.
 */
@Service
@Transactional
public class PatientServiceImpl implements PatientService {

  @Autowired
  private PatientRepository patientRepository;

  @Autowired
  private DocumentationRepository documentationRepository;

  @Autowired
  private DocumentationFileRepository documentationFileRepository;

  @Override
  public List<Patient> getFullListOfPatients() {
    Iterable<Patient> patientsIterable = patientRepository.findAll();
    List<Patient> patients = new ArrayList<>();
    patientsIterable.forEach(patients::add);
    return patients;
  }

  @Override
  public List<DocumentationDTO> getFullPatientDocumentation(String patientId) {
    Iterable<Documentation> documentationIterable = documentationRepository.findAll(QDocumentation.documentation.patient.id.eq(Long.valueOf(patientId)));
    List<Documentation> documentations = new ArrayList<>();
    documentationIterable.forEach(documentations::add);

    List<DocumentationDTO> documentationDTOS = new ArrayList<>();

    for (Documentation documentation : documentations) {
      DocumentationDTO documentationDTO = new DocumentationDTO();

      Iterable<DocumentationFile> documentationFileIterable = documentationFileRepository.findAll(QDocumentationFile.documentationFile1.documentation.id.eq(documentation.getId()));

      List<DocumentationFile> documentationFiles = new ArrayList<>();
      documentationFileIterable.forEach(documentationFiles::add);

      documentationDTO.setDocumentation(documentation);
      if (documentationFiles.size() > 0) {
        documentationDTO.setDocumentationFiles(documentationFiles);
      }

      documentationDTOS.add(documentationDTO);
    }

    return documentationDTOS;
  }
}
