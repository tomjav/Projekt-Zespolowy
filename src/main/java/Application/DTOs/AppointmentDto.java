package Application.DTOs;

import java.util.Date;

public class AppointmentDto {

  private Long id;

  private Long patientId;

  private Date date;

  private int hour;

  public Long getPatientId() {
    return patientId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getHour() {
    return hour;
  }

  public void setHour(int hour) {
    this.hour = hour;
  }


}
