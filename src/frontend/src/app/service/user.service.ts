import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { catchError, Observable, tap, throwError } from 'rxjs';
import { CustomHttpResponse, Profile } from '../interface/appstates';
import {User} from "../interface/user";


@Injectable({
  providedIn: 'root'
})
export class UserService {
  private readonly server: string = 'http://localhost:8080';

  constructor(private http: HttpClient) {
  }

  login$ = (email: string, password: string) => <Observable<CustomHttpResponse<Profile>>>
    this.http.post<CustomHttpResponse<Profile>>
    (`${this.server}/user/login`, {email, password})
      .pipe(
        tap(console.log),
        catchError(this.handleError)
      );

  verifyCode$ = (email: string, code: string) => <Observable<CustomHttpResponse<Profile>>>
    this.http.get<CustomHttpResponse<Profile>>
    (`${this.server}/user/verify/code/${email}/${code}`)
      .pipe(
        tap(console.log),
        catchError(this.handleError)
      );

  profile$ = () => <Observable<CustomHttpResponse<Profile>>>
    this.http.get<CustomHttpResponse<Profile>>
    (`${this.server}/user/profile`, { headers: new HttpHeaders().set('Authorization', 'Bearer eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJBTkRSRV9TRVBUSUFOX0FQUExJQ0FUSU9OIiwiYXVkIjoiQ1VTVE9NRVJfTUFOQUdFTUVOVF9TRVJWSUNFIiwiaWF0IjoxNzAwNjU1MzE2LCJzdWIiOiIxIiwiYXV0aG9yaXRpZXMiOlsiUkVBRDpVU0VSIiwiIFJFQUQ6Q1VTVE9NRVIiXSwiZXhwIjoxNzAwNzQxNzE2fQ.bCkK8nJ8kKeXV71loUGNwFGBjqKIILt7tuNDC5l9FaI_2XD9nE1C1-JUXGC-Q7DGZ6Wxk-kSv9eUiIj8kgYlhw') })
      .pipe(
        tap(console.log),
        catchError(this.handleError)
      );

  update$ = (user: User) => <Observable<CustomHttpResponse<Profile>>>
    this.http.patch<CustomHttpResponse<Profile>>
    (`${this.server}/user/update`, user, { headers: new HttpHeaders().set('Authorization', 'Bearer eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJBTkRSRV9TRVBUSUFOX0FQUExJQ0FUSU9OIiwiYXVkIjoiQ1VTVE9NRVJfTUFOQUdFTUVOVF9TRVJWSUNFIiwiaWF0IjoxNzAwNjU1MzE2LCJzdWIiOiIxIiwiYXV0aG9yaXRpZXMiOlsiUkVBRDpVU0VSIiwiIFJFQUQ6Q1VTVE9NRVIiXSwiZXhwIjoxNzAwNzQxNzE2fQ.bCkK8nJ8kKeXV71loUGNwFGBjqKIILt7tuNDC5l9FaI_2XD9nE1C1-JUXGC-Q7DGZ6Wxk-kSv9eUiIj8kgYlhw') })
      .pipe(
        tap(console.log),
        catchError(this.handleError)
      );

  private handleError(error: HttpErrorResponse): Observable<never> {
    console.log(error);
    let errorMessage: string;
    if (error.error instanceof ErrorEvent) {
      errorMessage = `A client error occurred - ${error.error.message}`;
    } else {
      if (error.error.reason) {
        errorMessage = error.error.reason;
        console.log(errorMessage);
      } else {
        errorMessage = `An error occurred - Error status ${error.status}`;
      }
    }
    return throwError(() => errorMessage);
  }
}
