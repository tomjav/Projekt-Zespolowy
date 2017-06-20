import {NgModule} from "@angular/core";
import {LoginComponent} from "../login/login.component";
import {FormsModule} from "@angular/forms";
import {LoginPopup} from "./login-popup/login-popup";

@NgModule({
  imports: [
    FormsModule
    // PopupModule.forRoot()
  ],
  declarations: [
    LoginComponent,
    LoginPopup
  ],
  exports: [
    LoginPopup,
    LoginComponent
  ]
})
export class SharedModule {

}
