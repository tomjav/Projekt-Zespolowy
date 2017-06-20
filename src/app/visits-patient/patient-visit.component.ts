import {Component, OnInit} from "@angular/core";
import {PatientService} from "../patient/services/patient.service";

@Component({
  templateUrl: 'patient-visit.component.html',
  selector: 'patient-visit'
})
export class PatientVisitComponent implements OnInit{

  ngOnInit(): void {
    this.getPatientId();
  }

  employee : any;
  appointment : any;

  success = false;
  patientId : any;

  toRemoved : number[] = [];


  onNotifyEmployee(message: any){
    console.log("Otrzymalem employee" + message);
    this.employee = message;
    this.appointment = undefined;
    this.success = false;
  }

  onNotifyAppointment(message: any){
    console.log("Otrzymalem appointment" + message);
    this.appointment = message;
  }

  arrangeAppointment(){
    var r = confirm("Czy na pewno umówić wizyte w podanym terminie?");
    console.log(r);
    console.log("WTF z tym alertem");
    if (r == true) {
      this.addAppointment();
      this.employee = undefined;
    }
  }

  getPatientId(): void {

    this.patientService.getPatientId()
      .subscribe(
        data => {
          this.patientId = data;
          console.log("SUCESS");
        },
        error => {
          console.log("ERROR");
        },
        () => {
          console.log("Finished");
          localStorage.setItem("patientId", this.patientId);
        }
      );
  }

  addAppointment(){

    var dto = {
      patientId : this.patientId,
      id : this.appointment.id
    };

    this.patientService.addAppoint(dto)
      .subscribe(
      data => {
        console.log("SUCESS");
      },
      () => this.success = true
    );
  }


  constructor(private patientService : PatientService){

  }
}
