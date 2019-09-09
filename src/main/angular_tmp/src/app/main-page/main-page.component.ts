import {Component, OnInit} from '@angular/core';
import {ServerGist} from '../gist';
import {GistsApiService} from '../gists-api.service';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.scss']
})
export class MainPageComponent implements OnInit {

  gists: Array<ServerGist>;

  currentPage = 1;
  sortBy = 'creationDate';

  isDateSort = true;
  isEvaluationSort = false;
  isLanguageSort = false;

  pagesCount = [];

  constructor(private gistsApiService: GistsApiService) {
  }

  ngOnInit() {
    this.gistsApiService.getGistsCount().subscribe(
      response => this.createPagesArray(response),
      error => console.log(error)
    );
    this.getGists();
  }

  createPagesArray(gistsCount: number) {
    const pagesCount = gistsCount % 6 === 0 ? Math.floor(gistsCount / 6) : Math.floor(gistsCount / 6) + 1;
    for (let i = 0; i < pagesCount; i++) {
      this.pagesCount.push(i);
    }
  }

  changePage(pageNumber: number) {
    this.currentPage = pageNumber;
    this.getGists();
  }

  setDateActiveState() {
    this.isDateSort = true;
    this.isEvaluationSort = false;
    this.isLanguageSort = false;

    this.sortBy = 'creationDate';

    this.getGists();
  }

  setEvaluationActiveState() {
    this.isDateSort = false;
    this.isEvaluationSort = true;
    this.isLanguageSort = false;

    this.sortBy = 'evaluation';

    this.getGists();
  }

  setLanguageActiveState() {
    this.isDateSort = false;
    this.isEvaluationSort = false;
    this.isLanguageSort = true;

    this.sortBy = 'programmingLanguage';

    this.getGists();
  }

  getGists() {
    this.gistsApiService.getPageableGistsList(this.sortBy, this.currentPage - 1).subscribe(
      response => this.gists = response,
      error => console.log(error)
    );
  }

}
