package Application.Model;

import javax.persistence.*;

/**
 * Created by gwlodarczyk on 2017-04-26.
 */
@Entity
@Table(name = "WORKING_HOURS")
public class WorkingHours {

  @Id
  @Column(name = "ID_WORKING_HOURS", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_WORKING_HOURS")
  @SequenceGenerator(name = "SEQ_WORKING_HOURS", sequenceName = "SEQ_WORKING_HOURS", allocationSize = 1)
  private Long id;

  @OneToOne
  @JoinColumn(name = "ID_EMPLOYEE")
  private Employee employee;

  @OneToOne
  @JoinColumn(name = "ID_DAY_OF_THE_WEEK")
  private DayOfTheWeek dayOfTheWeek;

  @Basic
  @Column(name = "FROM_TIME", unique = false, nullable = false)
  private String fromTime;

  @Basic
  @Column(name = "TO_TIME", unique = false, nullable = false)
  private String toTime;

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

  public DayOfTheWeek getDayOfTheWeek() {
    return dayOfTheWeek;
  }

  public void setDayOfTheWeek(DayOfTheWeek dayOfTheWeek) {
    this.dayOfTheWeek = dayOfTheWeek;
  }

  public String getFromTime() {
    return fromTime;
  }

  public void setFromTime(String fromTime) {
    this.fromTime = fromTime;
  }

  public String getToTime() {
    return toTime;
  }

  public void setToTime(String toTime) {
    this.toTime = toTime;
  }
}
