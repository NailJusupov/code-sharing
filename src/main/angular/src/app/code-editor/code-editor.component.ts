import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-code-editor',
  templateUrl: './code-editor.component.html',
  styleUrls: ['./code-editor.component.scss']
})
export class CodeEditorComponent implements OnInit {

  @Input() fileName: string;
  @Input() programmingLanguage: string;
  @Input() code: string;

  @Output() onInputName = new EventEmitter();
  @Output() onInputLanguage = new EventEmitter();
  @Output() onInputCode = new EventEmitter();

  fileNameInputId = 'fileNameInputId';
  languageInputId = 'languageInputId';

  constructor() { }

  ngOnInit() {
  }

  getFileName(fileName: string) {
    this.onInputName.next(fileName);
  }

  getProgrammingLanguage(programmingLanguage: string) {
    this.onInputLanguage.next(programmingLanguage);
  }

  getCode(code: string) {
    this.onInputCode.next(code);
  }
}
