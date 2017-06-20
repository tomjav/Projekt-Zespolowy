import {Injectable} from "@angular/core";
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs";
import {IPatient} from "../patient";

@Injectable()
export class PatientService {

  private url: string = "http://localhost:8080/patient/list/all";
  private urlAppoint: string = "http://localhost:8080/appointment";
  private getIdUrl: string = "http://localhost:8080/patient";

  constructor(private http: Http) {

  }

  getPatientsList(): Observable<IPatient[]> {
    console.log("Pobieram pacjentow");
    return this.http
      .get(this.url)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json() || "Server error"));
  }

  addAppoint(dto): Observable<any> {

    var headers = new Headers();
    headers.append("content-type", 'application/json');
    headers.append("authorization", localStorage.getItem('token'));
    let url = `${this.urlAppoint}`;
    console.log("Wysylam post pod url " + url);
    return this.http
      .post(url, dto, headers)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json() || "Server error"));
  }

  getPatientId() : Observable<any> {

    var name = localStorage.getItem("firstname");
    var lastname = localStorage.getItem("lastname");
    var properUrl = this.getIdUrl + "?name="+name+"&surname="+lastname;

    console.log("Pobieranie id uzytkownika");
    return this.http
      .get(properUrl)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json() || "Server error"));
  }

}
