import {Component, Input, OnInit} from '@angular/core';
import {GistsApiService} from '../gists-api.service';
import {ServerGist} from '../gist';

@Component({
  selector: 'app-code-short-info-card',
  templateUrl: './code-short-info-card.component.html',
  styleUrls: ['./code-short-info-card.component.scss']
})
export class CodeShortInfoCardComponent implements OnInit {

  @Input() gist: ServerGist;

  constructor(private gistApiService: GistsApiService) { }

  ngOnInit() {
  }

  setStar() {

    this.gistApiService.setStar(this.gist.id).subscribe(
      response => this.gist.starsCount++,
      error => console.log(error)
    );
  }

}
