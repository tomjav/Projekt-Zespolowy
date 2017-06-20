import {IDoctor} from "./doctor";
import {IPatient} from "./patient";

export interface ICard {
  id: number;
  employee: IDoctor;
  patient: IPatient;
  timeOfInscription: Date;
  title: string;
  text: string;
}
