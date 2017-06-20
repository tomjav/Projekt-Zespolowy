import {Injectable} from "@angular/core";
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs";

@Injectable()
export class RegisterService {

  private employeeUrl: string = "http://localhost:8080/register?userType=EMPLOYEE";
  private patientUrl: string = "http://localhost:8080/register?userType=PATIENT";


  constructor(private http: Http) {

  }

  addUser(option, dto): Observable<string[]> {
    console.log("Dodaje użytkownika");
    var headers = new Headers();

    headers.append("content-type", 'application/json');
    headers.append("authorization", localStorage.getItem('token'));
    let options = new RequestOptions({headers: headers});

    if(option === 'employee'){

      let url = `${this.employeeUrl}`;
      console.log("Wysylam post pod url " + url);

      return this.http
        .post(url, dto, headers)
        .map((res: Response) => res.json())
        .catch((error: any) => Observable.throw(error.json() || "Server error"));
    }else {

      let url = `${this.patientUrl}`;
      console.log("Wysylam post pod url " + url);

      return this.http
        .post(url, dto, headers)
        .map((res: Response) => res.json())
        .catch((error: any) => Observable.throw(error.json() || "Server error"));
    }
  }
}
