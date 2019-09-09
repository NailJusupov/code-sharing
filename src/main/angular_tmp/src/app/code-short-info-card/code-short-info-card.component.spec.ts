import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CodeShortInfoCardComponent } from './code-short-info-card.component';

describe('CodeShortInfoCardComponent', () => {
  let component: CodeShortInfoCardComponent;
  let fixture: ComponentFixture<CodeShortInfoCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CodeShortInfoCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CodeShortInfoCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
