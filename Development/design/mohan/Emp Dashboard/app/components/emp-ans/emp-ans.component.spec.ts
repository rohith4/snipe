import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpAnsComponent } from './emp-ans.component';

describe('EmpAnsComponent', () => {
  let component: EmpAnsComponent;
  let fixture: ComponentFixture<EmpAnsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpAnsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpAnsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
