import {Inject, Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {UserRegisterFormData} from './user';

@Injectable({
  providedIn: 'root'
})
export class UserApiService {

  constructor(private httpClient: HttpClient,
              @Inject('BASE_API_URL') private baseUrl: string
  ) { }

  public register(userFormData: UserRegisterFormData): Observable<any> {
    return this.httpClient.post(`${this.baseUrl}/auth/registration`, userFormData, {observe: 'response'});
  }

  public authenticate(userFormData: FormData): Observable<any> {
    return this.httpClient.post(`${this.baseUrl}/auth/login`, userFormData, {observe: 'response', withCredentials: true});
  }

  public getAuthUserInfo(): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}/auth/userInfo`, {observe: 'response', withCredentials: true});
  }

  public logout(): Observable<any> {
    return this.httpClient.post(`${this.baseUrl}/auth/logout`, {}, {observe: 'response'});
  }
}
