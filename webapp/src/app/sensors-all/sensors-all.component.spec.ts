import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {SensorsAllComponent} from './sensors-all.component';

describe('SensorsAllComponent', () => {
  let component: SensorsAllComponent;
  let fixture: ComponentFixture<SensorsAllComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [SensorsAllComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SensorsAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
