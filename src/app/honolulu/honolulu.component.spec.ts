import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HonoluluComponent } from './honolulu.component';

describe('HonoluluComponent', () => {
  let component: HonoluluComponent;
  let fixture: ComponentFixture<HonoluluComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HonoluluComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HonoluluComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
