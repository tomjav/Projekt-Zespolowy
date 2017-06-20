import {Injectable} from "@angular/core";
import {IPatientCriteria} from "./patient-criteria";

@Injectable()
export class PatientCriteriaService {

  criteria: IPatientCriteria = new IPatientCriteria();
  viewedPatientsCounter: number = 0;
}
