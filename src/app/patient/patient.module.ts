import {NgModule} from "@angular/core";
import {PatientListComponent} from "./patient-list/patient-component";
import {PatientFilterPipe} from "./patient-list/patient-filter.pipe";
import {PatientCardComponent} from "./card/karta-pacjenta.component";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {CardManegmentComponent} from "./card-management/card-manegment.component";
import {ParientSearchComponent} from "./patient-search/patient-search.component";
import {PatientCardListComponent} from "./card-list/card-list.component";
import {PatientDetailsComponent} from "./patient-details/patient-details.component";
import {PatientService} from "./services/patient.service";
import {CardService} from "./services/card.service";
import {PatientCriteriaPipe} from "./patient-search/patient-criteria-pipe";
import {PatientCriteriaService} from "./patient-search/patient-criteria-shared-service";
import {PopupComponent} from "../components/popup/popup.component";
import {PatientCardEditComponent} from "./card-edit/card-edit.component";
import {SharedModule} from "../shared/shared.module";
import {PatientCardAddComponent} from "./card-add/card-add.component";

@NgModule({
  declarations: [
    ParientSearchComponent,
    PatientListComponent,
    PatientDetailsComponent,
    PatientFilterPipe,
    PatientCriteriaPipe,
    PopupComponent,
    PatientCardEditComponent,
    PatientCardAddComponent,

    CardManegmentComponent,
    PatientCardComponent,
    PatientCardListComponent
  ],
  imports: [
    SharedModule,
    BrowserModule,

    FormsModule,
    HttpModule,
    ReactiveFormsModule
  ],
  providers: [
    PatientService,
    CardService,
    PatientCriteriaService
  ]

})
export class PatientModule {
}
