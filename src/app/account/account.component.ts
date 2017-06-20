import {Component} from "@angular/core";

@Component({
  selector: 'panel-admin',
  templateUrl: 'account.component.html'
})
export class AccountComponent {

  chosenAccount : any;

  onChooseAccount(message : any){
    this.chosenAccount = message;
  }


}

