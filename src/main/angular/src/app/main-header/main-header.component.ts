import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main-header',
  templateUrl: './main-header.component.html',
  styleUrls: ['./main-header.component.scss']
})
export class MainHeaderComponent implements OnInit {

  isSignInWindowOpen = false;
  isSignUpWindowOpen = false;
  isUserLogged = false;
  userName: string;

  constructor() { }

  ngOnInit() {
  }

  changeSignInWindowState(isOpen: boolean): void {
    this.isSignInWindowOpen = isOpen;
    this.isSignUpWindowOpen = false;
  }

  changeSignUpWindowState(isOpen: boolean): void {
    this.isSignUpWindowOpen = isOpen;
    this.isSignInWindowOpen = false;
  }

  showUserBar(userName: string): void {
    this.isUserLogged = true;
    this.userName = userName;
  }

  hideUserBar() {
    this.isUserLogged = false;
    this.userName = '';
  }

}