import {Inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Gist} from './gist';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GistsApiService {

  constructor(
    private httpClient: HttpClient,
    @Inject('BASE_API_URL') private baseUrl: string
  ) { }

  public createGist(gistFormData: Gist): Observable<any> {
    return this.httpClient.post( `${this.baseUrl}/gists/add-gist`, gistFormData, {observe: 'response', withCredentials: true});
  }

  public getPageableGistsList(sortBy: string, pageNumber: number): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}/gists/get-all-gists?pageNumber=${pageNumber}&sortBy=${sortBy}`);
  }

  public getGistsCount(): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}/gists/get-gists-count`);
  }

  public setStar(gistId: number): Observable<any> {
    return this.httpClient.post(`${this.baseUrl}/stars/set-star-to-gist`, gistId, {observe: 'response', withCredentials: true});
  }

  public getGistById(gistId: number): Observable<any> {
    return  this.httpClient.get(`${this.baseUrl}/gists/get-gist-by-id?gistId=${gistId}`, {observe: 'response'});
  }

  public deleteGistById(gistId: number): Observable<any> {
    return this.httpClient.delete(`${this.baseUrl}/gists/delete-gist-by-id?gistId=${gistId}`, {withCredentials: true});
  }

  public getGistOwnerInfo(gistId: number): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}/gists/get-is-user-owner-info?gistId=${gistId}`, {withCredentials: true});
  }

  public getGistsByTitle(gistTitle: String): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}/gists/get-gist-by-title?gistTitle=${gistTitle}`);
  }

  public getPageableGistsListByParam(searchParam: string, pageNumber: number): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}/gists/get-all-gists-by-search-param?pageNumber=${pageNumber}&searchParam=${searchParam}`, {withCredentials: true});
  }

  public getGistsCountByParam(searchParam: string): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}/gists/get-all-gists-count-by-search-param?searchParam=${searchParam}`, {withCredentials: true});
  }

  public updateGist(gistFormData: Gist): Observable<any> {
    return this.httpClient.put(`${this.baseUrl}/gists/update-gist`, gistFormData, {observe: 'response', withCredentials: true});
  }

}
