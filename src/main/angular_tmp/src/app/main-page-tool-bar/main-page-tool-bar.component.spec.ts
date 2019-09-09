import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MainPageToolBarComponent } from './main-page-tool-bar.component';

describe('MainPageToolBarComponent', () => {
  let component: MainPageToolBarComponent;
  let fixture: ComponentFixture<MainPageToolBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MainPageToolBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MainPageToolBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
