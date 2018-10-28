import { TestBed } from '@angular/core/testing';

import { ForumcommentsService } from './forumcomments.service';

describe('ForumcommentsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ForumcommentsService = TestBed.get(ForumcommentsService);
    expect(service).toBeTruthy();
  });
});
