///<reference path="../../employee/employee.ts"/>
import {Component, Input, OnInit} from "@angular/core";
import {CardService} from "../services/card.service";
import {NgForm} from "@angular/forms";
import {EmployeeService} from "../../employee/services/employee-service";

@Component({
  selector: 'med-card-edit',
  templateUrl: 'card-edit.component.html',
  styleUrls: ["card-edit.component.css"]
})
export class PatientCardEditComponent implements OnInit {


  // @Input() patient: IPatient;
  @Input() card: any;
  edited: any = {};

  surname : string;
  employeeId : any;

  doctors: any[] = [];

  showPatientList: boolean = true;
  success = false;

  ngAfterViewInit() {
    this.showPatientList = true;
  }

  onEditClick(editCardForm: NgForm): void {


    let dto = editCardForm.value;
    dto.employeeId = localStorage.getItem("id");
    dto.id = this.card.documentation.id;

    console.log(this.card);

    this.cardService.editCard(dto)
      .subscribe(
        error => console.log(error),
        () => {
          console.log("Finished");
          this.success = true;
        }
      );
    this.success = true;
  }

  constructor(private cardService: CardService,
              private  employeeService: EmployeeService) {
    console.log(this.card);
  }

  ngOnInit(): void {
    console.log("On init edit popup, try to catch employees");
    this.employeeService.getPatientsList()
      .subscribe(
        data => {
          this.doctors = data;
          console.log(this.doctors);
        },
        error => console.log(error),
        () => console.log("Finished")
      );

    this.getEmployeeId();

    this.surname = localStorage.getItem("lastname");
    //make current doctor first
    //this.doctors.

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
}
