import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {UserApiService} from '../user-api.service';
import {UserRegisterFormData} from '../user';
import {error} from 'util';

@Component({
  selector: 'app-user-registration-form',
  templateUrl: './user-registration-form.component.html',
  styleUrls: ['./user-registration-form.component.scss']
})
export class UserRegistrationFormComponent implements OnInit {

  @Input() isOpen: boolean;

  @Output() closeRegisterWindow = new EventEmitter();

  emailInputId = 'emailRegInput';

  nameInputId = 'nameRegInput';

  passwordInputId = 'passwordRegInput';

  repeatPasswordInputId = 'repeatPasswordRegInput';

  userFormData: UserRegisterFormData = new UserRegisterFormData();

  constructor(private userApiService: UserApiService) { }

  ngOnInit() {

  }

  closeWindow(): void {
    this.closeRegisterWindow.next();
  }

  setEmail(email: string) {
    this.userFormData.email = email;
  }

  setName(name: string) {
    this.userFormData.name = name;
  }

  setPassword(password: string) {
    this.userFormData.password = password;
  }

  setPasswordRepeat(password: string) {
    this.userFormData.password = password;
  }

  register() {
    this.userApiService.register(this.userFormData).subscribe(
      value => console.log(value),
      error1 => console.log(error1)
    );
  }


}
