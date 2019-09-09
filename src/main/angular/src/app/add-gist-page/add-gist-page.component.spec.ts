import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddGistPageComponent } from './add-gist-page.component';

describe('AddGistPageComponent', () => {
  let component: AddGistPageComponent;
  let fixture: ComponentFixture<AddGistPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddGistPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddGistPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
