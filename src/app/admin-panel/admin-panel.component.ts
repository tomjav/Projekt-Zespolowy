import {Component} from "@angular/core";

@Component({
  selector: 'panel-admin',
  styleUrls: ['admin-panel.component.css'],
  templateUrl: 'admin-panel.component.html'
})
export class AdminPanelComponent {

  addUser : string;

  onAddPatient(){
    this.addUser = 'patient';
    console.log("dodaj pacjenta");
  }
  onAddEmployee(){
    this.addUser = 'employee';
    console.log("dodaj pracownika");
  }
  back(){
    this.addUser = undefined;
  }
}

