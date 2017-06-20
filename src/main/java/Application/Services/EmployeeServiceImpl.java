package Application.Services;

import Application.Model.Employee;
import Application.Repository.EmployeeRepository;
import Application.Services.Interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gwlodarczyk
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {


  @Autowired
  EmployeeRepository employeeRepository;

  @Override
  public List<Employee> getEmployeesList() {
    List<Employee> employees = new ArrayList<>();
    Iterable<Employee> employeeIterable = employeeRepository.findAll();
    employeeIterable.forEach(employees::add);

    return employees;
  }
}
