import { TestBed } from '@angular/core/testing';

import { ForumpostService } from './forumpost.service';

describe('ForumpostService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ForumpostService = TestBed.get(ForumpostService);
    expect(service).toBeTruthy();
  });
});
