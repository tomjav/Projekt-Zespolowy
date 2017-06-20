package Application.Model;

import javax.persistence.*;

/**
 * Created by gwlodarczyk on 2017-04-26.
 */
@Entity
@Table(name = "DAY_OF_THE_WEEK")
public class DayOfTheWeek {

  @Id
  @Column(name = "ID_DAY_OF_THE_WEEK", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DAY_OF_THE_WEEK")
  @SequenceGenerator(name = "SEQ_DAY_OF_THE_WEEK", sequenceName = "SEQ_DAY_OF_THE_WEEK", allocationSize = 1)
  private Long id;

  @Basic
  @Column(name = "NAME", unique = true, nullable = false)
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
