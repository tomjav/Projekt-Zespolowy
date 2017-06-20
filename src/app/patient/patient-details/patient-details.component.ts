import {Component, Input} from "@angular/core";
import {IPatient} from "../patient";

@Component({
  templateUrl: 'patient-details.component.html',
  selector: 'patient-details'
})
export class PatientDetailsComponent {

  @Input() patient: IPatient;

}
