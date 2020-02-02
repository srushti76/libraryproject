import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BorrowedbooksComponent } from './borrowedbooks.component';

describe('BorrowedbooksComponent', () => {
  let component: BorrowedbooksComponent;
  let fixture: ComponentFixture<BorrowedbooksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BorrowedbooksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BorrowedbooksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
