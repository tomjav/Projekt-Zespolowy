package Application.Controllers;

import Application.DTOs.AppointmentDto;
import Application.Model.Appointment;
import Application.Model.Patient;
import Application.Repository.AppointmentRepository;
import Application.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.PipedOutputStream;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

  @Autowired
  private PatientRepository patientRepository;
  @Autowired
  private AppointmentRepository appointmentRepository;

  @RequestMapping(method = RequestMethod.POST)
  public void addAppointment(@RequestBody AppointmentDto appointmentDto){

    Patient patient = patientRepository.findOne(appointmentDto.getPatientId());
    Appointment appointment = appointmentRepository.findOne(appointmentDto.getId());
    appointment.setPatient(patient);
    appointmentRepository.save(appointment);

  }
}
