import {Component, OnInit} from "@angular/core";
import {EmployeeService} from "../services/employee-service";

@Component({
  templateUrl: 'employee-appointment.component.html',
  selector: 'employee-appointment',
  styleUrls: ['employee-appointment.component.css']
})
export class EmployeeAppointmentComponent implements OnInit{


  ngOnInit(): void {
   this.getPlannedAppoint();
  }

  appointments : any[] = [];


  constructor(private employeeService : EmployeeService){

  }

  getPlannedAppoint(): void {
    this.employeeService.getPlannedAppointment()
      .subscribe(
        data => {
          this.appointments = data;
          console.log("SUCESS");
        },
        error => {
          console.log("ERROR");
        },
        () => {
          console.log("Finished");
        }
      );
  }

  cancelAppoint(appointment){


    var response = confirm("Czy na pewno usunąć wizytę?");
    if(response != true) return;

    let appointmentId = appointment.id;
    this.employeeService.cancelAppointment(appointmentId).subscribe(
      data => {

      },
      error => {
        location.reload();
      },
      () => {

      }
    );



  }


  removeElement(id){
    var index = this.appointments.findIndex(function (element) {
      return element === id;
    });
    this.appointments.splice(index, 1);
  }

}
