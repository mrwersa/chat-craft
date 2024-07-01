import { TestBed } from '@angular/core/testing';

import { AppsmithService } from './appsmith.service';

describe('AppsmithService', () => {
  let service: AppsmithService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AppsmithService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
