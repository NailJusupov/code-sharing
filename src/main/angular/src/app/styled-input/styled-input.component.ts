import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-styled-input',
  templateUrl: './styled-input.component.html',
  styleUrls: ['./styled-input.component.scss']
})

export class StyledInputComponent implements OnInit {

  @Input() id: string;
  @Input() type: string;
  @Input() inputTitle: string;
  @Input() extraClass: string;
  @Input() inputValue: string;

  @Output() onInputValue = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  onInput(inputValue: string): void {
    this.onInputValue.next(inputValue);
  }

}
