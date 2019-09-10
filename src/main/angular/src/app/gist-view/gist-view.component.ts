import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ServerGist} from '../gist';
import {GistsApiService} from '../gists-api.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-gist-view',
  templateUrl: './gist-view.component.html',
  styleUrls: ['./gist-view.component.scss']
})
export class GistViewComponent implements OnInit {

  gist = new ServerGist();
  isUserOwner = false;
  currentPage = 1;


  constructor(private gistsApiService: GistsApiService,
              private route: ActivatedRoute) {}

  ngOnInit() {
    this.getGist();
  }

  getGist() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.gistsApiService.getGistById(id).subscribe(
      response => this.gist = response.body,
      error => console.log(error)
    );

    this.gistsApiService.getGistOwnerInfo(id).subscribe(
      response => this.isUserOwner = response,
      error => console.log(error)
    )
  }

  setStar() {
    this.gistsApiService.setStar(this.gist.id).subscribe(
      response => this.gist.starsCount++,
      error => console.log(error)
    );
  }

  changePage(pageNumber: number) {
    this.currentPage = pageNumber;
  }

  deleteGist() {
    this.gistsApiService.deleteGistById(this.gist.id).subscribe(
      response => alert('success'),
      error => console.log(error)
    );
  }

}
