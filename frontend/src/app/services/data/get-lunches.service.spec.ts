import { TestBed } from '@angular/core/testing';

import { GetLunchesService } from './get-lunches.service';

describe('GetLunchesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GetLunchesService = TestBed.get(GetLunchesService);
    expect(service).toBeTruthy();
  });
});
