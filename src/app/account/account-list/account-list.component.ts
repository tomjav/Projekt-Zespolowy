import {Component, Output, EventEmitter} from "@angular/core";
import {EmployeeService} from "../../employee/services/employee-service";

@Component({
  selector: 'account-list',
  styleUrls: ['account-list.component.css'],
  templateUrl: 'account-list.component.html'
})
export class AccountListComponent {

  accounts : any[] = [];

  @Output() chosenAccount: EventEmitter<any> = new EventEmitter<any>();

  ngOnInit(): void {
    this.employeeService.getAccountList()
      .subscribe((data) => this.accounts = data);
  }


  onChosenAccount(account){
    console.log(account);
    this.chosenAccount.emit(account);
  }

  constructor(private employeeService: EmployeeService) {

  }
}

