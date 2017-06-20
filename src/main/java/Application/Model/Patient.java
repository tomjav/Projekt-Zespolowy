package Application.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by gwlodarczyk on 2017-04-26.
 */
@Entity
@Table(name = "PATIENT")
public class Patient {

  @Id
  @Column(name = "ID_PATIENT", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PATIENT")
  @SequenceGenerator(name = "SEQ_PATIENT", sequenceName = "SEQ_PATIENT", allocationSize = 1)
  private Long id;

  @Basic
  @Column(name = "NAME", unique = false, nullable = false)
  private String name;

  @Basic
  @Column(name = "SURNAME", unique = false, nullable = false)
  private String surname;

  @Basic
  @Column(name = "DATE_OF_BIRTH", unique = false, nullable = false)
  private Date dateOfBirth;

  @Basic
  @Column(name = "ADDRESS", unique = false, nullable = false)
  private String address;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ID_ACCOUNT")
  private Account account;

  @Basic
  @Column(name = "GENDER", unique = false, nullable = true, columnDefinition="CHAR")
  private String gender;

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

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }
}
