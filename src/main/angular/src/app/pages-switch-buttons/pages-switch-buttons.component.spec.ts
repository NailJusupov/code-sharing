import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PagesSwitchButtonsComponent } from './pages-switch-buttons.component';

describe('PagesSwitchButtonsComponent', () => {
  let component: PagesSwitchButtonsComponent;
  let fixture: ComponentFixture<PagesSwitchButtonsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PagesSwitchButtonsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PagesSwitchButtonsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
