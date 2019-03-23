import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditJabatanComponent } from './edit-jabatan.component';

describe('EditJabatanComponent', () => {
  let component: EditJabatanComponent;
  let fixture: ComponentFixture<EditJabatanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditJabatanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditJabatanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
