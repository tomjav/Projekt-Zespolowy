package Application.Services.Interfaces;


import Application.DTOs.RegisterDTO;
import Application.Model.*;
import Application.Repository.AccountRepository;
import Application.Repository.EmployeeRepository;
import Application.Repository.EmployeeTypeRepository;
import Application.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.jdo.annotations.Transactional;

@Service
public class RegisterService {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private PatientRepository patientRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private EmployeeTypeRepository employeeTypeRepository;


  @Transactional
  public void registerPatient(RegisterDTO registerDTO) {

    Account account = getAccount(registerDTO.getAccount());
    Role role = new Role();
    role.setId(2L);
    role.setRole("ROLE_PATIENT");
    account.setRole(role);
    Patient patient = registerDTO.getPatient();
    patient.setAccount(account);
    patientRepository.save(patient);
  }

  @Transactional
  public void registerEmployee(RegisterDTO registerDTO) {

    Account account = getAccount(registerDTO.getAccount());
    Role role = new Role();
    role.setId(3L);
    role.setRole("ROLE_EMPLOYEE");
    account.setRole(role);
    Employee employee = registerDTO.getEmployee();
    //accountRepository.save(account);
    EmployeeType type = employeeTypeRepository.findByTitle(registerDTO.getEmployeeType());
    employee.setEmployeeType(type);
    employee.setAccount(account);
    employeeRepository.save(registerDTO.getEmployee());
  }

  private Account getAccount(Account account){
    String password = account.getPassword();
    String encodePassword = encodePassword(password);
    account.setPassword(encodePassword);
    return account;
  }

  private String encodePassword(String password){
     return passwordEncoder.encode(password);
  }



}
