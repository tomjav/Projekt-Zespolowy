import {Component, ViewChild, ElementRef, Output, EventEmitter} from "@angular/core";
import {LoginService} from "./login.service";
import {NgForm} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'med-login',
  templateUrl: "login.component.html",
  styleUrls: ["login.component.css"],
  providers: [LoginService]
})
export class LoginComponent {

  constructor(private loginService: LoginService, private router: Router) {
  }

  token: string;
  @ViewChild('closeBtn') closeBtn: ElementRef;
  userDetails: any;

  error = "Wpisz nazwę użytkownika oraz hasło";

  @Output() logged: EventEmitter<any> = new EventEmitter<void>();

  login(editCardForm: NgForm, event: Event): void {
    console.log("Proboje logowac");

    let dto = editCardForm.value;

    //console.log(dto);

    this.loginService.getToken(dto).subscribe(
      data => this.token = data,
      error => this.error = "Nieprawidłowa nazwa użytkownika lub hasło",
      () => {
        console.log("Pobrano token!");
        console.log(this.token);
        localStorage.setItem("token", this.token);
        this.loginService.getUserDetails().subscribe(
          data => this.userDetails = data,
          error => console.log(error),
          () => {
            console.log("Pobrano dane uzytkownika!");
            console.log(this.userDetails);
            localStorage.setItem("firstname", this.userDetails.firstname);
            localStorage.setItem("lastname", this.userDetails.lastname);
            localStorage.setItem("id", this.userDetails.id);
            this.closeBtn.nativeElement.click();
            this.logged.emit(this.userDetails);
            this.router.navigateByUrl("/");
            location.reload();
          }
        );
      }
    );
  }
}


