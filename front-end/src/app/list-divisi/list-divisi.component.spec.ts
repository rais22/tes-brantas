import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListDivisiComponent } from './list-divisi.component';

describe('ListDivisiComponent', () => {
  let component: ListDivisiComponent;
  let fixture: ComponentFixture<ListDivisiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListDivisiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListDivisiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
