import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {UserApiService} from '../user-api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-menu',
  templateUrl: './user-menu.component.html',
  styleUrls: ['./user-menu.component.scss']
})
export class UserMenuComponent implements OnInit {

  @Input() userName: string;
  @Output() hideUserBar = new EventEmitter();

  isWindowActive = false;

  constructor(private userApiService: UserApiService,
              private router: Router) { }

  ngOnInit() {
  }

  changeUserWindowState(): void {
    this.isWindowActive = !this.isWindowActive;
  }

  closeUserWindow(): void {
    this.isWindowActive = false;
  }

  logout() {
    this.router.navigate(['']);
    this.userApiService.logout().subscribe(
      response => this.hideUserBar.next(),
      error => console.log(error)
    );
  }

}
