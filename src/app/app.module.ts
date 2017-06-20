import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {AppComponent} from "./app.component";
import {PatientModule} from "./patient/patient.module";
import {RouterModule} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {CalendarComponent} from "./calendar/calendar.component";
import {MenuComponent} from "./menu/menu.component";
import {SharedModule} from "./shared/shared.module";
import {StartComponent} from "./start/start.component";
import {CardManegmentComponent} from "./patient/card-management/card-manegment.component";
import {CurrentUserComponent} from "./current-user/current-user.component";
import {AdminPanelComponent} from "./admin-panel/admin-panel.component";
import {RegistrationComponent} from "./registration/registration.component";
import {RegisterService} from "./registration/register.service";
import {PatientVisitComponent} from "./visits-patient/patient-visit.component";
import {EmployeeListComponent} from "./employee/employee-list/employee-list.component";
import {EmployeeService} from "./employee/services/employee-service";
import {AppointmentComponent} from "./appointment/appointment.component";
import {AppointmentListComponent} from "./appointment-list/appointment-list.component";
import {EmployeeAppointmentComponent} from "./employee/employee-appointment/employee-appointment.component";
import {AccountComponent} from "./account/account.component";
import {AccountEditComponent} from "./account/account-edit/account-edit.component";
import {AccountListComponent} from "./account/account-list/account-list.component";

@NgModule({
  declarations: [
    AppComponent,
    StartComponent,
    HomeComponent,
    CalendarComponent,
    MenuComponent,
    AdminPanelComponent,
    CurrentUserComponent,
    RegistrationComponent,
    EmployeeListComponent,
    PatientVisitComponent,
    AppointmentComponent,
    AppointmentListComponent,
    EmployeeAppointmentComponent,
    AccountComponent,
    AccountEditComponent,
    AccountListComponent
  ],
  imports: [
    PatientModule,
    SharedModule,
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([
      {path: 'karta-pacjenta', component: CardManegmentComponent},
      {path: 'start', component: StartComponent},
      {path: 'dostepnosc', component: AppointmentComponent},
      {path: 'panel-admina',component: AdminPanelComponent},
      {path: 'wizyty', component: EmployeeAppointmentComponent},
      {path: 'umow-wizyte', component: PatientVisitComponent},
      {path: 'kalendarz', component: CalendarComponent},
      {path: 'rejestracja', component: RegistrationComponent},
      {path: 'edycja-kont', component: AccountComponent},
      {path: 'moje-konto', redirectTo: 'panel-admin', pathMatch: 'full'},
      {path: '**', redirectTo: 'start', pathMatch: 'full'}
    ])
  ],
  providers: [RegisterService, EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
