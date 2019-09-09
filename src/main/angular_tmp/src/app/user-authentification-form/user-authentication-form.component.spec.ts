import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserAuthenticationFormComponent } from './user-authentication-form.component';

describe('UserAuthentificationFormComponent', () => {
  let component: UserAuthenticationFormComponent;
  let fixture: ComponentFixture<UserAuthenticationFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserAuthenticationFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserAuthenticationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
