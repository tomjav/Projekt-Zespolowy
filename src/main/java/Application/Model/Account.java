package Application.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by gwlodarczyk on 2017-04-26.
 */
@Entity
@Table(name = "ACCOUNT")
public class Account {

  @Id
  @Column(name = "ID_ACCOUNT", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACCOUNT")
  @SequenceGenerator(name = "SEQ_ACCOUNT", sequenceName = "SEQ_ACCOUNT", allocationSize = 1)
  private Long id;

  @Basic
  @Column(name = "USERNAME", unique = true, nullable = false)
  private String username;

  @Basic
  @Column(name = "PASSWORD", unique = false, nullable = false)
  private String password;

//  @Basic
//  @Column(name = "USER_TYPE", unique = false, nullable = false, columnDefinition="CHAR")
//  private String userType;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Role.class)
  @JoinColumn(name = "USER_TYPE")
  private Role role;

//  @JsonIgnore
//  @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
//  private Employee employee;
//
//  @JsonIgnore
//  @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
//  private Patient patient;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}
