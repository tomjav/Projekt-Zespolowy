import {Component, Output, EventEmitter} from "@angular/core";
import {Router} from "@angular/router";

@Component({
  selector: 'current-user',
  templateUrl: "current-user.component.html",

})
export class CurrentUserComponent {

  currentName: string;
  currentSurname: string;

  showPopup: boolean = false;

  @Output() logged: EventEmitter<any> = new EventEmitter<void>();

  onClickPopup(): void {
    this.showPopup = true;
  }

  onNotify(flag: boolean): void {
    console.log("ZAMYKAM POPUP");
    this.showPopup = flag;
  }

  success(userDetails) {
    this.check();
  }

  constructor(private router: Router) {
    this.check();
    console.log("firstname " + this.currentName);
    console.log("lastname " + this.currentSurname);
  }

  reset() {
    this.currentName = null;
    this.currentSurname = null;
  }

  check() {
    this.currentName = localStorage.getItem('firstname');
    this.currentSurname = localStorage.getItem('lastname');
  }

  logout() {
    this.reset();
    console.log("wylogowywanie uzytkownika");
    localStorage.clear();
    this.router.navigateByUrl("/");
    location.reload();
  }
}
