import {Component, Output, EventEmitter, OnInit} from "@angular/core";
import {IPatient} from "../patient";
import {PatientService} from "../services/patient.service";
import {PatientCriteriaService} from "../patient-search/patient-criteria-shared-service";
import {setInterval} from "timers";

@Component({
  selector: 'patient-list',
  templateUrl: 'patient.component.html',
  styleUrls: ['patient.component.css']
})
export class PatientListComponent implements OnInit {


  filterPhrase: string;
  filterBy: string = 'name';
  filterByProperties: string[];

  @Output() choosenPatientId: EventEmitter<IPatient> = new EventEmitter<IPatient>();

  patients: IPatient[];

  ngOnInit(): void {
    this.patientService.getPatientsList().subscribe((data) => this.patients = data);
  }


  patientClicked(patient: IPatient): void {
    console.log("wybrano pacjenta o id: " + patient.id);
    this.choosenPatientId.emit(patient);
  }


  constructor(private patientService: PatientService,
              private criteriaService: PatientCriteriaService) {


    // setInterval(function() {
    //   console.log("Logger");
    //   console.log(criteriaService.criteria)
    // }, 1000);

    //   let keys = [];
    //
    //   for (var key in this.patients[0]) {
    //
    //     if (typeof this[key] !== 'function') {
    //       keys.push(key);
    //     }
    //   }
    //   console.log("Property:" + JSON.stringify(keys));
    //
    //   this.filterByProperties = keys;
  }
}

