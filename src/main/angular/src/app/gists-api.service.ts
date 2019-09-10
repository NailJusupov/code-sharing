import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Gist} from './gist';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GistsApiService {

  constructor(private httpClient: HttpClient) { }

  public createGist(gistFormData: Gist): Observable<any> {
    return this.httpClient.post('/api/gists/add-gist', gistFormData, {observe: 'response'});
  }

  public getPageableGistsList(sortBy: string, pageNumber: number): Observable<any> {
    return this.httpClient.get(`/api/gists/get-all-gists?pageNumber=${pageNumber}&sortBy=${sortBy}`);
  }

  public getGistsCount(): Observable<any> {
    return this.httpClient.get('/api/gists/get-gists-count');
  }

  public setStar(gistId: number): Observable<any> {
    return this.httpClient.post('/api/stars/set-star-to-gist', gistId, {observe: 'response'});
  }

  public getGistById(gistId: number): Observable<any> {
    return  this.httpClient.get(`/api/gists/get-gist-by-id?gistId=${gistId}`, {observe: 'response'});
  }

  public deleteGistById(gistId: number): Observable<any> {
    return this.httpClient.delete(`/api/gists/delete-gist-by-id?gistId=${gistId}`);
  }

  public getGistOwnerInfo(gistId: number): Observable<any> {
    return this.httpClient.get(`/api/gists/get-gist-owner-info?gistId=${gistId}`);
  }

  public getGistsByTitle(gistTitle: String): Observable<any> {
    return this.httpClient.get(`/api/gists/get-gist-by-title?gistTitle=${gistTitle}`);
  }

  public getPageableGistsListByParam(searchParam: string, pageNumber: number): Observable<any> {
    return this.httpClient.get(`/api/gists/get-all-gists-by-search-param?pageNumber=${pageNumber}&searchParam=${searchParam}`);
  }

  public getGistsCountByParam(searchParam: string): Observable<any> {
    return this.httpClient.get(`/api/gists/get-all-gists-count-by-search-param?searchParam=${searchParam}`);
  }

}
