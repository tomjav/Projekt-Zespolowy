import {Component, OnInit, Input, OnChanges, SimpleChanges, Output, EventEmitter} from "@angular/core";
import {EmployeeService} from "../employee/services/employee-service";

@Component({
  selector: "appointment-list",
  templateUrl: "appointment-list.component.html",
  styleUrls: ["appointment-list.component.css"]
})
export class AppointmentListComponent implements OnInit, OnChanges{

  ngOnChanges(changes: SimpleChanges): void {
    this.getAppoint();
  }

  @Input() employee : any;
  @Input() toRemoved : number[];

  @Output() chosenAppointment: EventEmitter<any> = new EventEmitter<any>();

  appointments : any[] = [];

  ngOnInit(): void {
    this.getAppoint();
  }

  onSelectAppointment(appointment){
    console.log(appointment);
    console.log(appointment.length);
    // this.removeElement(appointment.id);
    console.log(appointment.length);
    this.chosenAppointment.emit(appointment);
  }

  getAppoint(): void {
    console.log("Pobieram dostępność");
    console.log(this.employee.id);
    console.log(this.employee);
    this.employeeService.getAppoint(this.employee.id)
      .subscribe(
        data => {
          this.appointments = data;
        },
        error => {
          console.log("ERROR");
        },
        () => console.log("JUPI")
      );
  }

  constructor(private employeeService: EmployeeService) {

  }

  removeElement(id){
    var index = this.appointments.findIndex(function (element) {
      return element === id;
    });
    this.appointments.splice(index, 1);
  }
}
