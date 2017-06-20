package Application.Controllers;

import Application.DTOs.AppointmentDto;
import Application.Model.Appointment;
import Application.Model.Employee;
import Application.Model.EmployeeType;
import Application.Repository.AppointmentRepository;
import Application.Repository.EmployeeRepository;
import Application.Repository.EmployeeTypeRepository;
import Application.Services.Interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gwlodarczyk
 */
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private EmployeeTypeRepository employeeTypeRepository;

  @Autowired
  private AppointmentRepository appointmentRepository;

  @Autowired
  private EmployeeRepository employeeRepository;


  @RequestMapping(value = "/get-list", method = RequestMethod.GET)
  public List<Employee> getEmployees() {
    return employeeService.getEmployeesList();
  }

  @RequestMapping(value = "/employee/type", method = RequestMethod.GET)
  public List<EmployeeType> getEmployeeTypes(){
    return employeeTypeRepository.findAll();
  }

  @RequestMapping(value = "/appointment", method = RequestMethod.POST)
  public void addAppointment(@RequestBody AppointmentDto input){

    Appointment appointment = new Appointment();
    Employee employee = employeeRepository.findOne(input.getId());
    appointment.setEmployee(employee);
    appointment.setDate(input.getDate());
    appointment.setHour(input.getHour());
    appointmentRepository.save(appointment);
  }

  @RequestMapping(value = "/{id}/appointment", method = RequestMethod.GET)
  public List<Appointment> getAppointmentForEmployee(@PathVariable(value = "id") Long id){
      return appointmentRepository.findAppointmentForEmployee(id);
  }

  @RequestMapping(value = "/{id}/appointment/planned", method = RequestMethod.GET)
  public List<Appointment> getPlannedAppointmentForEmployee(@PathVariable(value = "id") Long id){
      return appointmentRepository.findAppointmentForEmployeeWithPatient(id);
  }

  @RequestMapping(value = "/{id}/appointment/planned/cancel", method = RequestMethod.POST)
  public void cancelAppointment(@PathVariable(value = "id") Long id){
    Appointment appointment = appointmentRepository.findOne(id);
    appointment.setPatient(null);
    appointmentRepository.save(appointment);
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public Long getAppointmentForEmployee(@RequestParam String name, @RequestParam String surname){
      return employeeRepository.findByNameAndSurname(name,surname);
  }
}
