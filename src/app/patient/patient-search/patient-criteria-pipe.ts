import {Pipe, PipeTransform} from "@angular/core";
import {IPatient} from "../patient";
import {IPatientCriteria} from "./patient-criteria";
import {PatientCriteriaService} from "./patient-criteria-shared-service";
import {isUndefined} from "util";

@Pipe({
  name: 'patientCriteriaPipe',
  pure: false
})
export class PatientCriteriaPipe implements PipeTransform {


  transform(patients: IPatient[], criteriaService: PatientCriteriaService): IPatient[] {


    var criteria: IPatientCriteria = criteriaService.criteria;

    if (isUndefined(patients)) return undefined;
    if (isUndefined(criteria)) return undefined;

    // console.log("Uruchomiono pipe");
    // console.log(criteria);

    let filtered: IPatient[] = patients.filter((patient: IPatient) => {

      if (!!criteria.name) {
        if (!this.contains(patient.name, criteria.name)) return false;
      }
      if (!!criteria.surname) {
        if (!this.contains(patient.surname, criteria.surname)) return false;
      }
      if (!!criteria.gender) {
        if (!this.contains(patient.gender, criteria.gender)) return false;
      }
      if (!!criteria.birthDateFrom) {
        if (this.isFromBiggerThanTo(patient.dateOfBirth, criteria.birthDateFrom)) return false;
      }

      return true;
    });

    criteriaService.viewedPatientsCounter = filtered.length;
    console.log("Zwrocono " + criteriaService.viewedPatientsCounter + " wynikow.")
    return filtered;

  }

  //usefull

  private contains(arg1: string, arg2: string): boolean {
    return arg1.search(arg2) != -1;
  }

  private isNotNull(sth: any) {
    return !!sth;
  }

  private isFromBiggerThanTo(dtmfrom: Date, dtmto: Date) {
    return new Date(dtmfrom).getTime() >= new Date(dtmto).getTime();
  }

}
