///<reference path="../../employee/employee.ts"/>
import {Component, Input, OnInit, ViewChild, ElementRef, Output, EventEmitter} from "@angular/core";
import {CardService} from "../services/card.service";
import {NgForm} from "@angular/forms";
import {EmployeeService} from "../../employee/services/employee-service";
import {ViewConstructorVars} from "@angular/compiler/src/view_compiler/constants";

@Component({
  selector: 'med-card-add',
  templateUrl: 'card-add.component.html',
  styleUrls: ["card-add.component.css"]
})
export class PatientCardAddComponent implements OnInit {

  doctors: any[] = [];
  @ViewChild('closeBtn') closeBtn: ElementRef;

  @Input() patient: any;
  @Output() addedCard: EventEmitter<void> = new EventEmitter<void>();

  success = false;
  error = false;
  employeeId : any;
  surname : string;

  onAddClick(editCardForm: NgForm, event: Event): void {

    let dto = editCardForm.value;
    dto.employeeId = this.employeeId;
    dto.patientId = this.patient.id;

    this.cardService.addCard(dto)
      .subscribe(
        data => {
          console.log("SUCESS");
          this.success = true;
          this.error = false;
          this.addedCard.emit();
        },
        error => {
          this.error = true;
          this.success = false;
          console.log("ERROR");
        },
        () => console.log("Finished")
      );

  }

  constructor(private cardService: CardService,
              private  employeeService: EmployeeService) {
  }

  ngOnInit(): void {
    console.log("On init edit popup, try to catch employees");
    this.employeeService.getPatientsList()
      .subscribe(
        data => {
          this.doctors = data;
          console.log(this.doctors);
        },
        error => alert(error),
        () => console.log("Finished")
      );

    this.getEmployeeId();
    this.surname = localStorage.getItem("lastname");
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
