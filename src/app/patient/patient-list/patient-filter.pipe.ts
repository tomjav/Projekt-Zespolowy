import {Pipe, PipeTransform} from "@angular/core";
import {IPatient} from "../patient";

@Pipe({
  name: 'patientPipe'
})
export class PatientFilterPipe implements PipeTransform {

  transform(patients: IPatient[], filterPhrase: string, filterBy: string): IPatient[] {

    if (!filterBy || !filterPhrase) return patients;

    let newArray = patients.filter((patient: IPatient) => {
      if (typeof patient[filterBy] !== 'string') patient[filterBy] = patient[filterBy] + "";
      return patient[filterBy].toLocaleLowerCase().indexOf(filterPhrase.toLocaleLowerCase()) !== -1;
    });
    return newArray;
  }
}
