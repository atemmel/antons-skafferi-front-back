import { TestBed } from '@angular/core/testing';

import { GetItemsService } from './get-items.service';

describe('GetItemsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GetItemsService = TestBed.get(GetItemsService);
    expect(service).toBeTruthy();
  });
});
