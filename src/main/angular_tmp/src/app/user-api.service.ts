import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {UserRegisterFormData} from './user';

@Injectable({
  providedIn: 'root'
})
export class UserApiService {

  constructor(private httpClient: HttpClient) { }

  public register(userFormData: UserRegisterFormData): Observable<any> {
    return this.httpClient.post('/api/auth/registration', userFormData, {observe: 'response'});
  }

  public authenticate(userFormData: FormData): Observable<any> {
    return this.httpClient.post('/api/auth/login', userFormData, {observe: 'response'});
  }

  public getAuthUserInfo(): Observable<any> {
    return this.httpClient.get('/api/auth/userInfo', {observe: 'response'});
  }

  public logout(): Observable<any> {
    return this.httpClient.post('/api/auth/logout', {}, {observe: 'response'});
  }
}
