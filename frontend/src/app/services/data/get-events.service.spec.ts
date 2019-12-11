import { TestBed } from '@angular/core/testing';

import { GetEventsService } from './get-events.service';

describe('GetEventsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GetEventsService = TestBed.get(GetEventsService);
    expect(service).toBeTruthy();
  });
});
