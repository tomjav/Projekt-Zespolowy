import {Component, Input} from "@angular/core";
import {EmployeeService} from "../../employee/services/employee-service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'account-edit',
  templateUrl: 'account-edit.component.html'
})
export class AccountEditComponent {

  @Input() chosenAccount;
  success = false;
  error : string;

  editAccount(edit: NgForm){
    console.log("edycja konta");
    var dto = edit.value;

    if(dto.role !== 'ROLE_PATIENT' && dto.role !== 'ROLE_ADMIN' && dto.role !== 'ROLE_DOCTOR' && dto.role !== 'ROLE_EMPLOYEE'){
      this.error = 'Podana rola jest nieprawidlowa, powinna byc ROLE_PATIENT lub ROLE_ADMIN lub ROLE_DOCTOR lub ROLE_EMPLOYEE';
      return;
    }

    dto.id = this.chosenAccount.id;
    this.employeeService.editAccount(dto).subscribe(
      data => {
        console.log("SUCESS");
      },
      error => {
        console.log("ERROR");
        this.success = true;
        location.reload();
        this.error = undefined;
      },
      () => console.log("Finished")
    );
  }

  constructor(private employeeService : EmployeeService){

  }
}

