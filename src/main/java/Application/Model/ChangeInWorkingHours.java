package Application.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by gwlodarczyk on 2017-04-26.
 */
@Entity
@Table(name = "CHANGE_IN_WORKING_HOURS")
public class ChangeInWorkingHours {

  @Id
  @Column(name = "ID_CHANGE_IN_WORK_HOURS", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CHANGE_IN_WORKING_HOURS")
  @SequenceGenerator(name = "SEQ_CHANGE_IN_WORKING_HOURS", sequenceName = "SEQ_CHANGE_IN_WORKING_HOURS", allocationSize = 1)
  private Long id;

  @OneToOne
  @JoinColumn(name = "ID_EMPLOYEE")
  private Employee employee;

  @Basic
  @Column(name = "DATE_FROM", unique = false, nullable = false)
  private Date dateFrom;

  @OneToOne
  @JoinColumn(name = "DAY_OF_THE_WEEK")
  private DayOfTheWeek dayOfTheWeek;

  @Basic
  @Column(name = "TIME_FROM", unique = false, nullable = false)
  private String timeFrom;

  @Basic
  @Column(name = "TIME_TO", unique = false, nullable = false)
  private String timeTo;

  @Basic
  @Column(name = "ACTION", unique = false, nullable = false, columnDefinition="CHAR")
  private String action;

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

  public Date getDateFrom() {
    return dateFrom;
  }

  public void setDateFrom(Date dateFrom) {
    this.dateFrom = dateFrom;
  }

  public DayOfTheWeek getDayOfTheWeek() {
    return dayOfTheWeek;
  }

  public void setDayOfTheWeek(DayOfTheWeek dayOfTheWeek) {
    this.dayOfTheWeek = dayOfTheWeek;
  }

  public String getTimeFrom() {
    return timeFrom;
  }

  public void setTimeFrom(String timeFrom) {
    this.timeFrom = timeFrom;
  }

  public String getTimeTo() {
    return timeTo;
  }

  public void setTimeTo(String timeTo) {
    this.timeTo = timeTo;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }
}
