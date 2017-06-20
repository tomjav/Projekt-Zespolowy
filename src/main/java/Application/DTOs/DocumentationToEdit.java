package Application.DTOs;

import Application.Config.GenericRestResponseConfig.GenericRestResponse;

import java.util.Date;

/**
 * @author gwlodarczyk
 */
public class DocumentationToEdit extends GenericRestResponse {
  private Long id;
  private Long employeeId;
  private String title;
  private String text;
  private Date timeOfInscription;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Date getTimeOfInscription() {
    return timeOfInscription;
  }

  public void setTimeOfInscription(Date timeOfInscription) {
    this.timeOfInscription = timeOfInscription;
  }
}
