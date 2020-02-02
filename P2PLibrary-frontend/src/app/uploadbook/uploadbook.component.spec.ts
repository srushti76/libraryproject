import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadbookComponent } from './uploadbook.component';

describe('UploadbookComponent', () => {
  let component: UploadbookComponent;
  let fixture: ComponentFixture<UploadbookComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UploadbookComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UploadbookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
