import { TestBed } from '@angular/core/testing';

import { GistsApiService } from './gists-api.service';

describe('GistsApiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GistsApiService = TestBed.get(GistsApiService);
    expect(service).toBeTruthy();
  });
});
