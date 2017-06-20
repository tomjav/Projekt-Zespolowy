import {Component, OnInit} from "@angular/core";
import {EmployeeService} from "../employee/services/employee-service";
import {NgForm} from "@angular/forms";

@Component({
  selector: "appointment",
  templateUrl: "appointment.component.html"
})
export class AppointmentComponent implements OnInit{

  sucess : boolean = false;

  error : string;

  employeeId : string;


  ngOnInit(): void {
    this.getEmployeeId();
    this.sucess = false;
  }

  getEmployeeId(): void {

     this.employeeService.getEmployeeId()
      .subscribe(
        data => {
          this.employeeId = data;
          console.log("SUCESS");
        },
        error => {
          console.log("ERROR");
        },
        () => {
            console.log("Finished");
            localStorage.setItem("id", this.employeeId);
        }
      );
  }

  addAppoint(editCardForm: NgForm, event: Event): void {

    let dto = editCardForm.value;

    if(isNaN(dto.hour) || dto.hour < 1 || dto.hour > 24){
      this.error = "Godzina powinna być podana jako liczba od 1 do 24, a data powinna byc uzupełniona";
      this.sucess = undefined;
      return;
    }

    this.error = undefined;

    this.employeeService.addAppoint(dto)
      .subscribe(
        data => {
          console.log("SUCESS");
        },
        error => {
          console.log("ERROR");
        },
        () => this.sucess = true
      );
    this.sucess = true;
    this.error = undefined;
  }

  constructor(private employeeService: EmployeeService) {

  }
}
