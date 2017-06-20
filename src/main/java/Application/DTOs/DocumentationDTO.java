package Application.DTOs;

import Application.Config.GenericRestResponseConfig.GenericRestResponse;
import Application.Model.Documentation;
import Application.Model.DocumentationFile;

import java.util.List;

/**
 * Created by gwlodarczyk on 29.04.2017.
 */
public class DocumentationDTO {
  private Documentation documentation;
  private List<DocumentationFile> documentationFiles;

  public Documentation getDocumentation() {
    return documentation;
  }

  public void setDocumentation(Documentation documentation) {
    this.documentation = documentation;
  }

  public List<DocumentationFile> getDocumentationFiles() {
    return documentationFiles;
  }

  public void setDocumentationFiles(List<DocumentationFile> documentationFiles) {
    this.documentationFiles = documentationFiles;
  }
}
