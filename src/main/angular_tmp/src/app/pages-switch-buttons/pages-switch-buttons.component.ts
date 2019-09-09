import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-pages-switch-buttons',
  templateUrl: './pages-switch-buttons.component.html',
  styleUrls: ['./pages-switch-buttons.component.scss']
})
export class PagesSwitchButtonsComponent implements OnInit {

  @Input() pagesArray: Array<any>;
  @Input() currentPage: number;
  @Output() changePage = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  onPageButtonClick(pageNumber: number) {
    this.changePage.next(pageNumber);
  }

}
