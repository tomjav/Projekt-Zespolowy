import {Injectable} from "@angular/core";
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs";
import {IEmployee} from "../employee";

@Injectable()
export class EmployeeService {

  private url: string = "http://localhost:8080/employee/get-list";
  private appointUrl: string = "http://localhost:8080/employee/appointment";
  private getIdUrl: string = "http://localhost:8080/employee/";
  private accountUrl: string = "http://localhost:8080/account";


  constructor(private http: Http) {

  }

  editAccount(dto){

    console.log("Edycja konta");
    var headers = new Headers();

    headers.append("content-type", 'application/json');
    headers.append("authorization", localStorage.getItem('token'));
    let options = new RequestOptions({headers: headers});

    let url = `${this.accountUrl}`;
    console.log("Wysylam post pod url " + url);

    return this.http
      .post(url, dto, headers)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json() || "Server error"));
  }


  getAccountList(): Observable<IEmployee[]> {
    console.log("Pobieram konta uzytkownikow");
    return this.http
      .get(this.accountUrl)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json() || "Server error"));
  }


  getPatientsList(): Observable<IEmployee[]> {
    console.log("Pobieram lekarzy");
    return this.http
      .get(this.url)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json() || "Server error"));
  }

  getEmployeeId() : Observable<any> {

    var name = localStorage.getItem("firstname");
    var lastname = localStorage.getItem("lastname");
    var properUrl = this.getIdUrl + "?name="+name+"&surname="+lastname;

    console.log("Pobieranie id uzytkownika");
    return this.http
      .get(properUrl)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json() || "Server error"));
  }

  addAppoint(dto): Observable<string[]> {
    dto.id = localStorage.getItem("id");
    console.log("Dodaje użytkownika");
    var headers = new Headers();

    headers.append("content-type", 'application/json');
    headers.append("authorization", localStorage.getItem('token'));
    let options = new RequestOptions({headers: headers});

    let url = `${this.appointUrl}`;
      console.log("Wysylam post pod url " + url);

      return this.http
        .post(url, dto, headers)
        .map((res: Response) => res.json())
        .catch((error: any) => Observable.throw(error.json() || "Server error"));
    }

    getAppoint(employeeId): Observable<string[]> {


    var properUrl = this.getIdUrl + employeeId + "/appointment";

    console.log("Dodaje użytkownika");
    var headers = new Headers();

    headers.append("content-type", 'application/json');
    headers.append("authorization", localStorage.getItem('token'));

      return this.http
        .get(properUrl, headers)
        .map((res: Response) => res.json())
        .catch((error: any) => Observable.throw(error.json() || "Server error"));
    }


    cancelAppointment(employeeId): Observable<any> {
    var properUrl = this.getIdUrl + employeeId + "/appointment" + "/planned/cancel";
    console.log("");
    var headers = new Headers();
    headers.append("content-type", 'application/json');
    headers.append("authorization", localStorage.getItem('token'));
      return this.http
        .post(properUrl, headers)
        .map((res: Response) => res.json())
        .catch((error: any) => Observable.throw(error.json() || "Server error"));
    }

    getPlannedAppointment(): Observable<any> {
    let employeeId = localStorage.getItem("id");
    var properUrl = this.getIdUrl + employeeId + "/appointment" + "/planned";
    var headers = new Headers();
    headers.append("content-type", 'application/json');
    headers.append("authorization", localStorage.getItem('token'));
      return this.http
        .get(properUrl, headers)
        .map((res: Response) => res.json())
        .catch((error: any) => Observable.throw(error.json() || "Server error"));
    }
}
