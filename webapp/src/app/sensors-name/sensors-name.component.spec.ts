import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {SensorsNameComponent} from './sensors-name.component';

describe('SensorsNameComponent', () => {
  let component: SensorsNameComponent;
  let fixture: ComponentFixture<SensorsNameComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [SensorsNameComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SensorsNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
