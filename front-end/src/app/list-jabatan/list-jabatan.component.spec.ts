import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListJabatanComponent } from './list-jabatan.component';

describe('ListJabatanComponent', () => {
  let component: ListJabatanComponent;
  let fixture: ComponentFixture<ListJabatanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListJabatanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListJabatanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
