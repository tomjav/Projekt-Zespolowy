import {Injectable} from "@angular/core";
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs";

@Injectable()
export class LoginService {

  url: string = "http://localhost:8080/auth";
  urlUser: string = "http://localhost:8080/user";

  constructor(private http: Http) {
  }

  getToken(dto: any): Observable<any> {
    var headers = new Headers();
    headers.append("content-type", 'application/json');
    headers.append('Access-Control-Allow-Origin', '*');
    let options = new RequestOptions({headers: headers});
    console.log("Pobieram token dla uzytkownika " + dto.username);
    return this.http.post(this.url, dto, options)
      .map((res: Response) => {
        let any = res.json().token;
        // console.log(any);
        return any;
      });
    // .catch((error: any) => Observable.throw(error.json() || "Server error"));
  }

  getUserDetails(): Observable<any> {
    var headers = new Headers();
    headers.append("content-type", 'application/json');
    headers.append("authorization", localStorage.getItem('token'));
    let options = new RequestOptions({headers: headers});
    console.log("Wysylam post pod url " + this.url);
    return this.http.get(this.urlUser, options)
      .map((res: Response) => {
        let any = res.json();
        return any;
      });

  }
}
