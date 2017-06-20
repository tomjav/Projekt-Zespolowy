package Application.Model;

import javax.persistence.*;

/**
 * Created by gwlodarczyk on 2017-04-26.
 */
@Entity
@Table(name = "EMPLOYEE_TYPE")
public class EmployeeType {

  @Id
  @Column(name = "ID_EMPLOYEE_TYPE", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMPLOYEE_TYPE")
  @SequenceGenerator(name = "SEQ_EMPLOYEE_TYPE", sequenceName = "SEQ_EMPLOYEE_TYPE", allocationSize = 1)
  private Long id;

  @Basic
  @Column(name = "TITLE", unique = true, nullable = false)
  private String title;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
