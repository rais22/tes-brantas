import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDivisiComponent } from './add-divisi.component';

describe('AddDivisiComponent', () => {
  let component: AddDivisiComponent;
  let fixture: ComponentFixture<AddDivisiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddDivisiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddDivisiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
