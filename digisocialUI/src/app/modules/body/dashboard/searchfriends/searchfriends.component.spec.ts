import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchfriendsComponent } from './searchfriends.component';

describe('SearchfriendsComponent', () => {
  let component: SearchfriendsComponent;
  let fixture: ComponentFixture<SearchfriendsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchfriendsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchfriendsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
