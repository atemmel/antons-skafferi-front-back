import { TestBed } from '@angular/core/testing';

import { GetCategoriesService } from './get-categories.service';

describe('GetCategoriesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GetCategoriesService = TestBed.get(GetCategoriesService);
    expect(service).toBeTruthy();
  });
});
