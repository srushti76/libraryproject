import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestreceivedComponent } from './requestreceived.component';

describe('RequestreceivedComponent', () => {
  let component: RequestreceivedComponent;
  let fixture: ComponentFixture<RequestreceivedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestreceivedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestreceivedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
