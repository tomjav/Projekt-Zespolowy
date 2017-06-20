import {Component, Input, ViewChild, ElementRef} from "@angular/core";
import {RegisterService} from "./register.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'registration',
  templateUrl: 'registration.component.html'
})
export class RegistrationComponent {

  @Input() variant : string;
  @ViewChild('#send') input: ElementRef;

  error : string;
  success = false;

  validacja(editCardForm: NgForm):string{
    let dto = editCardForm.value;
    if (!dto.username) this.error="Brak loginu";
    else if (!dto.password) this.error="Brak hasła";
    else if (!dto.passwordrepeat) this.error="Brak powtórzenia hasła";
    else if (dto.password.length>20) this.error="Za długie hasło. Max 20 znaków.";
    else if (!(dto.password===dto.passwordrepeat)) this.error="Hasła się nie zgadzają.";
    else if (!dto.name) this.error="Brak imienia";
    else if (dto.name.length>30) this.error="Za długie imie. Max 30 znaków";
    else if (!dto.surname) this.error="Brak nazwiska";
    else if (dto.surname.length>30) this.error="Za długie nazwisko. Max 30 znaków";
    else if (!dto.dateOfBirth) this.error="Brak daty urodzenia";
    else if (!dto.address) this.error="Brak adresu";
    else if (dto.address.length>30) this.error="Za długi adres. ";
    else if (!dto.gender) this.error="Brak płci";
    else if (dto.gender.toLowerCase()!="kobieta" && dto.gender.toLowerCase()!="mężczyzna") this.error="Zła płeć";
    return this.error;
  }


  register(editCardForm: NgForm, event: Event): void {
    if (this.validacja(editCardForm)) return;

    let dto = editCardForm.value;

    dto.gender = dto.gender === "Kobieta" ? "K" : "M";

    console.log(dto);

    var account = {
      username : dto.username,
      password : dto.password
    };

    var patient = {
      name : dto.name,
      surname : dto.surname,
      dateOfBirth : dto.dateOfBirth,
      address : dto.address,
      gender : dto.gender
    };
    var employee = {
      name : dto.name,
      surname : dto.surname,
      dateOfBirth : dto.dateOfBirth,
      address : dto.address,
      gender : dto.gender
    };

    if(this.variant === 'employee') {
      dto = {
        account : account,
        employee : employee,
        employeeType : dto.position
      };
    }
    else {
      dto = {
        account: account,
        patient: patient
      };
    }

    this.registerService.addUser(this.variant, dto)
      .subscribe(
        data => {
          console.log("SUCESS");
        },
        error => {
          console.log("ERROR");
          this.success = true;


        },
        () => console.log("Finished")
      );
    }
    constructor(private registerService : RegisterService) {

    }

}
