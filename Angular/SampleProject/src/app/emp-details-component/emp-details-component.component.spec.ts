import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpDetailsComponentComponent } from './emp-details-component.component';

describe('EmpDetailsComponentComponent', () => {
  let component: EmpDetailsComponentComponent;
  let fixture: ComponentFixture<EmpDetailsComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpDetailsComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpDetailsComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
