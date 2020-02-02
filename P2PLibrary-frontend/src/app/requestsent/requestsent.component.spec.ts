import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestsentComponent } from './requestsent.component';

describe('RequestsentComponent', () => {
  let component: RequestsentComponent;
  let fixture: ComponentFixture<RequestsentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestsentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestsentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
