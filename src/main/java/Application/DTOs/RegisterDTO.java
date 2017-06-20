package Application.DTOs;

import Application.Model.Account;
import Application.Model.Employee;
import Application.Model.Patient;

public class RegisterDTO {

  private Account account;
  private Patient patient;
  private Employee employee;
  private String employeeType;

  public String getEmployeeType() {
    return employeeType;
  }

  public void setEmployeeType(String employeeType) {
    this.employeeType = employeeType;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

}
