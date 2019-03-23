import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditDivisiComponent } from './edit-divisi.component';

describe('EditDivisiComponent', () => {
  let component: EditDivisiComponent;
  let fixture: ComponentFixture<EditDivisiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditDivisiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditDivisiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
