import { TestBed } from '@angular/core/testing';

import { GetImageService } from './get-image.service';

describe('GetImageService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GetImageService = TestBed.get(GetImageService);
    expect(service).toBeTruthy();
  });
});
