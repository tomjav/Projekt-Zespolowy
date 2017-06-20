package Application.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ROLE")
@Entity
public class Role {
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Id
  @Column(name = "ID_ROLE")
  private Long id;

  @Column(name = "ROLE")
  private String role;
}
