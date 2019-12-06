import { TestBed } from '@angular/core/testing';

import { GetTabelsService } from './get-tabels.service';

describe('GetTabelsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GetTabelsService = TestBed.get(GetTabelsService);
    expect(service).toBeTruthy();
  });
});
