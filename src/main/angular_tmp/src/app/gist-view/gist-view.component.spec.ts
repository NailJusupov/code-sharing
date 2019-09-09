import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GistViewComponent } from './gist-view.component';

describe('GistViewComponent', () => {
  let component: GistViewComponent;
  let fixture: ComponentFixture<GistViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GistViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GistViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
