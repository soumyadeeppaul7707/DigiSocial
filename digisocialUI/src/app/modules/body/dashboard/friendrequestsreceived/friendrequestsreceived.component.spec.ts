import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FriendrequestsreceivedComponent } from './friendrequestsreceived.component';

describe('FriendrequestsreceivedComponent', () => {
  let component: FriendrequestsreceivedComponent;
  let fixture: ComponentFixture<FriendrequestsreceivedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FriendrequestsreceivedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FriendrequestsreceivedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
