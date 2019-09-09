import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-main-page-tool-bar',
  templateUrl: './main-page-tool-bar.component.html',
  styleUrls: ['./main-page-tool-bar.component.scss']
})
export class MainPageToolBarComponent implements OnInit {

  @Input() isDateSort: boolean;
  @Input() isEvaluationSort: boolean;
  @Input() isLanguageSort: boolean;

  @Output() setDateActiveState = new EventEmitter();
  @Output() setEvaluationActiveState = new EventEmitter();
  @Output() setLanguageActiveState = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  onDateClick() {
    this.setDateActiveState.next();
  }

  onEvaluationClick() {
    this.setEvaluationActiveState.next();
  }

  onLanguageClick() {
    this.setLanguageActiveState.next();
  }

}
