import { TestBed } from '@angular/core/testing';

import { FriendandchatService } from './friendandchat.service';

describe('FriendandchatService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FriendandchatService = TestBed.get(FriendandchatService);
    expect(service).toBeTruthy();
  });
});
