import {Component, Input, Output, EventEmitter} from "@angular/core";

@Component({
  selector: 'login',
  templateUrl: 'login-popup.html'

})
export class LoginPopup {

  // ngOnChanges(changes: SimpleChanges): void {
  //   console.log("popinien pokazac popup");
  //   if (this.show) this.popup.show();
  // }


  @Input() show: boolean = false;
  @Output() notify: EventEmitter<boolean> = new EventEmitter<boolean>();

  // ngOnInit(): void {
  //   this.popup.options = {
  //     header: "Your custom header",
  //     color: "#254fb8", // red, blue....
  //     widthProsentage: 60, // The with of the popou measured by browser width
  //     animationDuration: 2, // in seconds, 0 = no animation
  //     showButtons: true, // You can show this in case you want to use custom buttons
  //     confirmBtnContent: "Zaloguj", // The text on your confirm button
  //     cancleBtnContent: "Wyjdź", // the text on your cancel button
  //     confirmBtnClass: "btn btn-default", // your class for styling the confirm button
  //     cancleBtnClass: "btn btn-default", // you class for styling the cancel button
  //     animation: "bounceInDown" // 'fadeInLeft', 'fadeInRight', 'fadeInUp', 'bounceIn','bounceInDown'
  //   };
  // }
  //
  // cancelEvent(): void {
  //   console.log("logout event!");
  //   this.show = false;
  //   this.popup.hide();
  //   this.notify.emit(this.show);
  // }

}
