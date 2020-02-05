import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicWallComponent } from './public-wall.component';

describe('PublicWallComponent', () => {
  let component: PublicWallComponent;
  let fixture: ComponentFixture<PublicWallComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PublicWallComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PublicWallComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
