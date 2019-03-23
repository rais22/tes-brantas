import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddJabatanComponent } from './add-jabatan.component';

describe('AddJabatanComponent', () => {
  let component: AddJabatanComponent;
  let fixture: ComponentFixture<AddJabatanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddJabatanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddJabatanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
