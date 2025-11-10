import { TestBed } from '@angular/core/testing';

import { PostetravailServiceService } from './postetravail-service.service';

describe('PostetravailServiceService', () => {
  let service: PostetravailServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PostetravailServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
