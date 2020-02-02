import { TestBed } from '@angular/core/testing';

import { HardAuthenticationService } from './hard-authentication.service';

describe('HardAuthenticationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HardAuthenticationService = TestBed.get(HardAuthenticationService);
    expect(service).toBeTruthy();
  });
});
