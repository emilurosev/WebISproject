import { TestBed } from '@angular/core/testing';

import { TopicService } from './topic-service.service';

describe('TopicServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TopicService = TestBed.get(TopicService);
    expect(service).toBeTruthy();
  });
});
