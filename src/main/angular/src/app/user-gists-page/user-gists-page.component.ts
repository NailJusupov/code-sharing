import { Component, OnInit } from '@angular/core';
import {ServerGist} from '../gist';
import {GistsApiService} from '../gists-api.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-user-gists-page',
  templateUrl: './user-gists-page.component.html',
  styleUrls: ['./user-gists-page.component.scss']
})
export class UserGistsPageComponent implements OnInit {

  gists: Array<ServerGist>;

  currentPage = 1;

  pagesCount = [];

  searchParam: string;

  constructor(private gistsApiService: GistsApiService,
              private route: ActivatedRoute) {
    this.route.params.subscribe(
      params => {
        this.searchParam = params['param'];
        this.getPagesCount();
        this.getGists();
      }
    )
  }

  ngOnInit() {

  }

  changePage(pageNumber: number) {
    this.currentPage = pageNumber;
    this.getGists();
  }

  getPagesCount() {
    this.pagesCount = [];

    this.gistsApiService.getGistsCountByParam(this.searchParam).subscribe(
      response => this.createPagesArray(response),
      error => console.log(error)
    );
  }

  createPagesArray(gistsCount: number) {

    const pagesCount = gistsCount % 6 === 0 ? Math.floor(gistsCount / 6) : Math.floor(gistsCount / 6) + 1;
    for (let i = 0; i < pagesCount; i++) {
      this.pagesCount.push(i);
    }
  }

  getGists() {

    this.gistsApiService.getPageableGistsListByParam(this.searchParam, this.currentPage - 1).subscribe(
      response => this.gists = response,
      error => console.log(error)
    );
  }

}
