package Application.Controllers;

import Application.DTOs.DocumentationToEdit;
import Application.DTOs.DocumentationToSave;
import Application.Model.Documentation;
import Application.Model.QDocumentation;
import Application.Repository.DocumentationRepository;
import Application.Services.Interfaces.DocumentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gwlodarczyk
 */
@RestController
@RequestMapping(value = "/documentation")
public class DocumentationController {

  @Autowired
  private DocumentationRepository documentationRepository;

  @Autowired
  private DocumentationService documentationService;

  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public Documentation editDocumentation(@RequestBody DocumentationToEdit documentationToEdit){
    Documentation documentation = documentationRepository.findOne(QDocumentation.documentation.id.eq(documentationToEdit.getId()));
    return documentationService.editDocumentation(documentation, documentationToEdit);
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public Documentation saveDocumentation(@RequestBody DocumentationToSave documentation){
    return documentationService.saveDocumentation(documentation);
  }

}
