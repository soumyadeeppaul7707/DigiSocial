import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FriendandchatComponent } from './friendandchat.component';

describe('FriendandchatComponent', () => {
  let component: FriendandchatComponent;
  let fixture: ComponentFixture<FriendandchatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FriendandchatComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FriendandchatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
