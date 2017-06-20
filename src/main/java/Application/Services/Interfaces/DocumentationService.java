package Application.Services.Interfaces;

import Application.DTOs.DocumentationToEdit;
import Application.DTOs.DocumentationToSave;
import Application.Model.Documentation;

/**
 * @author gwlodarczyk
 */
public interface DocumentationService {
  Documentation editDocumentation(Documentation documentation, DocumentationToEdit documentationToEdit);

  Documentation saveDocumentation(DocumentationToSave documentation);
}
