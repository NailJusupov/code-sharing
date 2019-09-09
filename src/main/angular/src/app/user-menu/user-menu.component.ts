import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {UserApiService} from '../user-api.service';

@Component({
  selector: 'app-user-menu',
  templateUrl: './user-menu.component.html',
  styleUrls: ['./user-menu.component.scss']
})
export class UserMenuComponent implements OnInit {

  @Input() userName: string;
  @Output() hideUserBar = new EventEmitter();

  isWindowActive = false;

  constructor(private userApiService: UserApiService) { }

  ngOnInit() {
  }

  changeUserWindowState(): void {
    this.isWindowActive = !this.isWindowActive;
  }

  logout() {
    this.userApiService.logout().subscribe(
      response => this.hideUserBar.next(),
      error => console.log(error)
    );
  }

}
