import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubjectsRegistrationComponent } from './subjects-registration.component';

describe('SubjectsRegistrationComponent', () => {
  let component: SubjectsRegistrationComponent;
  let fixture: ComponentFixture<SubjectsRegistrationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubjectsRegistrationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubjectsRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
