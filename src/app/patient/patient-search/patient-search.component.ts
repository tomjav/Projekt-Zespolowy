import {Component} from "@angular/core";
import {PatientCriteriaService} from "./patient-criteria-shared-service";

@Component({
  selector: 'patient-search',
  templateUrl: 'patient.search.component.html'
})
export class ParientSearchComponent {

  constructor(private criteriaService: PatientCriteriaService) {
  }

  find(): void {
    console.log(this.criteriaService.criteria);
  }


}
