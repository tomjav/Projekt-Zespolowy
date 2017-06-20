import {Component, OnInit, Output, EventEmitter} from "@angular/core";
import {EmployeeService} from "../services/employee-service";

@Component({
  selector: "employee-list",
  templateUrl: "employee-list.component.html",
  styleUrls: ["employee-list.component.css"]
})
export class EmployeeListComponent implements OnInit{

  employees : any[] = [];

  @Output() chosenEmployee: EventEmitter<any> = new EventEmitter<any>();

  ngOnInit(): void {
    this.employeeService.getPatientsList()
      .subscribe((data) => this.employees = data);
  }


  onChosenEmployee(employee){
    console.log(employee);
    this.chosenEmployee.emit(employee);
  }

  constructor(private employeeService: EmployeeService) {

  }
}
