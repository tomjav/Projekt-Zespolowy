import {Component, Input} from "@angular/core";
import {IPatient} from "../patient";

@Component({
  selector: 'patient-card',
  templateUrl: 'karta-pacjenta.component.html',
})
export class PatientCardComponent {

  // @Input() patient: IPatient;
  @Input() card: any;

  showPatientList: boolean = true;

  ngAfterViewInit() {
    this.showPatientList = true;
  }

  onEditClick(): void {

  }

}
