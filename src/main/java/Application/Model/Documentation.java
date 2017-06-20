package Application.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by gwlodarczyk on 2017-04-26.
 */
@Entity
@Table(name = "PATIENT_DOCUMENTATION")
public class Documentation {

  @Id
  @Column(name = "ID_PATIENT_DOCUMENTATION", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DOCUMENTATION")
  @SequenceGenerator(name = "SEQ_DOCUMENTATION", sequenceName = "SEQ_DOCUMENTATION", allocationSize = 1)
  private Long id;

  @OneToOne
  @JoinColumn(name = "ID_EMPLOYEE")
  private Employee employee;

  @OneToOne
  @JoinColumn(name = "ID_PATIENT")
  private Patient patient;

  @Basic
  @Column(name = "TIME_OF_INSCRIPTION", unique = false, nullable = false)
  private Date timeOfInscription;

  @Basic
  @Column(name = "TITLE", unique = false, nullable = false)
  private String title;

  @Basic
  @Column(name = "TEXT", unique = false, nullable = false)
  private String text;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
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
