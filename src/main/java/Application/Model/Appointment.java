package Application.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by gwlodarczyk on 2017-04-26.
 */
@Entity
@Table(name = "APPOINTMENT")
public class Appointment {

  @Id
  @Column(name = "ID_APPOINTMENT", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_APPOINTMENT")
  @SequenceGenerator(name = "SEQ_APPOINTMENT", sequenceName = "SEQ_APPOINTMENT", allocationSize = 1)
  private Long id;

  @OneToOne
  @JoinColumn(name = "ID_EMPLOYEE")
  private Employee employee;

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Integer getHour() {
    return hour;
  }

  public void setHour(Integer hour) {
    this.hour = hour;
  }

  @OneToOne
  @JoinColumn(name = "ID_PATIENT")
  private Patient patient;

  @Basic
  @Column(name = "A_DATE", unique = false, nullable = false)
  private Date date;

  @Column(name = "A_HOUR")
  private Integer hour;


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

}
