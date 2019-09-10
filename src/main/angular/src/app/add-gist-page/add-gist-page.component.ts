import { Component, OnInit } from '@angular/core';
import {File, Gist} from '../gist';
import {GistsApiService} from '../gists-api.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-add-gist-page',
  templateUrl: './add-gist-page.component.html',
  styleUrls: ['./add-gist-page.component.scss']
})
export class AddGistPageComponent implements OnInit {

  titleInputId = 'gistTitleInputId';
  programmingLanguageInputId = 'programmingLanguageInputId';

  gist = new Gist();

  file = new File();

  currentPage = 1;

  isError = false;
  isSucceed = false;

  isEditing: boolean;

  constructor(private gistsService: GistsApiService,
              private router: ActivatedRoute) {
    this.gist.files[0] = new File();
  }

  ngOnInit() {
    this.isEditing = Boolean(this.router.snapshot.paramMap.get('id'));
    this.getGist()
  }

  getGist() {
    if(this.isEditing) {
      this.gistsService.getGistById(+this.router.snapshot.paramMap.get('id')).subscribe(
        response => this.gist = response.body,
        error => console.log(error)
      )
    }
  }

  addFile() {
    this.gist.files.push(new File());
    this.currentPage = this.gist.files.length;
  }

  setTitle(title: string) {
    this.gist.title = title;
  }

  setDescription(description: string) {
    this.gist.description = description;
  }

  setFileName(fileName: string) {
    this.gist.files[this.currentPage - 1].fileName = fileName;
  }

  setProgrammingLanguage(programmingLanguage: string) {
    this.gist.programmingLanguage = programmingLanguage;
  }

  setCode(code: string) {
    this.gist.files[this.currentPage - 1].code = code;
  }

  setSuccess() {
    this.isSucceed = true;
    this.isError = false;
  }

  setError() {
    this.isSucceed = false;
    this.isError = true;
  }

  saveGist() {
    if(this.isEditing){
      this.gistsService.updateGist(this.gist).subscribe(
        response => this.setSuccess(),
        error => this.setError()
      );
    } else {
      this.gistsService.createGist(this.gist).subscribe(
        response => this.setSuccess(),
        error => this.setError()
      );
    }
  }

  changePage(pageNumber: number) {
    this.currentPage = pageNumber;
  }

}
