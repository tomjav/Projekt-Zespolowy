package Application.Model;

import javax.persistence.*;
import java.sql.Blob;

/**
 * Created by gwlodarczyk on 2017-04-26.
 */
@Entity
@Table(name = "DOCUMENTATION_FILE")
public class DocumentationFile {

  @Id
  @Column(name = "ID_DOCUMENTATION_FILE", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DOCUMENTATION_FILE")
  @SequenceGenerator(name = "SEQ_DOCUMENTATION_FILE", sequenceName = "SEQ_DOCUMENTATION_FILE", allocationSize = 1)
  private Long id;

  @Basic
  @Column(name = "FILE_NAME", unique = false, nullable = true)
  private String fileName;

  @Basic
  @Column(name = "DOCUMENTATION_FILE", unique = false, nullable = false)
  private Blob documentationFile;

  @OneToOne
  @JoinColumn(name = "ID_PATIENT_DOCUMENTATION")
  private Documentation documentation;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public Blob getDocumentationFile() {
    return documentationFile;
  }

  public void setDocumentationFile(Blob documentationFile) {
    this.documentationFile = documentationFile;
  }

  public Documentation getDocumentation() {
    return documentation;
  }

  public void setDocumentation(Documentation documentation) {
    this.documentation = documentation;
  }
}
