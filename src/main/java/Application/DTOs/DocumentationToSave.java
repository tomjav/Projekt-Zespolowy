package Application.DTOs;

import java.util.Date;

/**
 * Created by gwlodarczyk on 29.05.2017.
 */
public class DocumentationToSave {
  private long patientId;
  private long employeeId;
  private Date timeOfInscription;
  private String title;
  private String text;

  public long getPatientId() {
    return patientId;
  }

  public void setPatientId(long patientId) {
    this.patientId = patientId;
  }

  public long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(long employeeId) {
    this.employeeId = employeeId;
  }

  public Date getTimeOfInscription() {
    return timeOfInscription;
  }

  public void setTimeOfInscription(Date timeOfInscription) {
    this.timeOfInscription = timeOfInscription;
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
}
