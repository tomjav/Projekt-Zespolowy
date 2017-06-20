import {Injectable} from "@angular/core";
import {Http, Response, Headers} from "@angular/http";
import {Observable} from "rxjs";
import {IPatient} from "../patient";

@Injectable()
export class CardService {

  private url: string = "http://localhost:8080/patient/documentation/";
  private documentationUrl: string = "http://localhost:8080/documentation/edit";
  private addDocumentationUrl: string = "http://localhost:8080/documentation/save";

  constructor(private http: Http) {

  }

  getCardList(patient: IPatient): Observable<any[]> {
    console.log("Pobieram dokumentacje pacjenta " + patient.surname);
    return this.http
      .get(this.url + patient.id)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json() || "Server error"));
  }

  editCard(editCard: any): Observable<any[]> {

    var body = editCard;
    var headers = new Headers();
    headers.append("content-type", 'application/json');
    headers.append("test", 'test');

    let url = `${this.documentationUrl}`;
    console.log("Wysylam post pod url " + url);

    return this.http
      .post(url, body, headers)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json() || "Server error"));
  }

  addCard(editCard: any): Observable<any[]> {

    var body = editCard;
    var headers = new Headers();
    headers.append("content-type", 'application/json');
    headers.append("test", 'test');

    let url = `${this.addDocumentationUrl}`;
    console.log("Wysylam post pod url " + url);

    return this.http
      .post(url, body, headers)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json() || "Server error"));
  }
}
