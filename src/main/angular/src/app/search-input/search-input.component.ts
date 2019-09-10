import { Component, OnInit } from '@angular/core';
import {ServerGist} from '../gist';
import {GistsApiService} from '../gists-api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-input',
  templateUrl: './search-input.component.html',
  styleUrls: ['./search-input.component.scss']
})
export class SearchInputComponent implements OnInit {

  gists: Array<ServerGist> = new Array<ServerGist>();

  constructor(private gistsApiService: GistsApiService, private router: Router) { }

  ngOnInit() {

  }

  setSearchParam(searchParam: string) {
    if(searchParam === '') {
      this.gists = new Array<ServerGist>()
    } else {
      this.gistsApiService.getGistsByTitle(searchParam).subscribe(
        response => this.gists = response,
        error => console.log(error)
      )
    }
  }

  goToFirstGist() {
    if(this.gists.length !== 0) {
      this.router.navigate([`gist/${this.gists[0].id}`])
    }
  }

}
