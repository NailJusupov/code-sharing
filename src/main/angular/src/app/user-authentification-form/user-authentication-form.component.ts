import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {UserAuthFormData} from '../user';
import {UserApiService} from '../user-api.service';

@Component({
  selector: 'app-user-authentication-form',
  templateUrl: './user-authentication-form.component.html',
  styleUrls: ['./user-authentication-form.component.scss']
})
export class UserAuthenticationFormComponent implements OnInit {

  @Input() isOpen: boolean;

  @Output() closeAuthWindow = new EventEmitter();
  @Output() changeUserBarState = new EventEmitter();

  emailInputId = 'emailAuthInput';
  passwordInputId = 'passwordAuthInput';

  userFormData: UserAuthFormData = new UserAuthFormData();

  isDataCorrect = true;

  constructor(private userApiService: UserApiService) { }

  ngOnInit() {
  }

  closeWindow(): void {
    this.closeAuthWindow.next();
  }

  setEmail(email: string): void {
    this.userFormData.email = email;
  }

  setPassword(password: string): void {
    this.userFormData.password = password;
  }

  authenticate() {
    const formData: FormData = new FormData();

    formData.append('username', this.userFormData.email);
    formData.append('password', this.userFormData.password);

    this.userApiService.authenticate(formData).subscribe(
      response => {
        if (response.status === 401) {
            this.isDataCorrect = true
        } else {
          this.userApiService.getAuthUserInfo().subscribe(
            res => {
              this.closeWindow();
              const user: any = res.body;
              this.changeUserBarState.next(user.name);
            },
            error => console.log(error)
          );
        }
      },
      error => {
        this.isDataCorrect = false;
      }
    );
  }

}
