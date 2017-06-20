import {Injectable} from "@angular/core";
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs";

@Injectable()
export class MenuService {

  private menuUrl: string = "http://localhost:8080/menu";

  constructor(private http: Http) {

  }

  getMenuOption(): Observable<string[]> {
    console.log("Pobieram menu użytkownika");
    var headers = new Headers();
    headers.append("content-type", 'application/json');
    headers.append("authorization", localStorage.getItem('token'));
    let options = new RequestOptions({headers: headers});
    return this.http
      .get(this.menuUrl,options)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json() || "Server error"));
  }
}
