import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { YourWallComponent } from './your-wall.component';

describe('YourWallComponent', () => {
  let component: YourWallComponent;
  let fixture: ComponentFixture<YourWallComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ YourWallComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(YourWallComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
