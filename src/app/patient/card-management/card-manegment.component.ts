import {Component} from "@angular/core";
import {IPatient} from "../patient";

@Component({
  templateUrl: "card-manegment.component.html",
  selector: "ng-card-manegment"
})
export class CardManegmentComponent {

  patient: IPatient;
  patientCard: any; //problem z mapowaniem JSONa na obiekt / zalatwiam zwyklym JS

  onNotify(message: IPatient): void {
    this.patient = message;
  }

  onNotifyCard(message: any): void {
    console.log("ON NOTIFY CARD");
    this.patientCard = message;
  }

  reset(): void {
    console.log("reset");
    this.patient = undefined;
    this.patientCard = undefined;
  }

  resetCard(): void {
    this.patientCard = undefined;
  }
}
