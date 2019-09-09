import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-stars-count',
  templateUrl: './stars-count.component.html',
  styleUrls: ['./stars-count.component.scss']
})
export class StarsCountComponent implements OnInit {

  @Input() starsCount: number;
  @Output() setStar = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  onStarClick() {
    this.setStar.next();
  }

}
