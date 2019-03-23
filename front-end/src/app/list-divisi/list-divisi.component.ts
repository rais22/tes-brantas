import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {DivisiService} from "../service/divisi.service";
import {Divisi} from "../model/divisi.model";

@Component({
  selector: 'app-list-divisi',
  templateUrl: './list-divisi.component.html',
  styleUrls: ['./list-divisi.component.css']
})
export class ListDivisiComponent implements OnInit {

  divisis: Divisi[];

  constructor(private router: Router, private divisiService: DivisiService) { }

  ngOnInit() {
    this.divisiService.getDivisis()
      .subscribe( data => {
        this.divisis = data;
      });
  }

  deleteDivisi(divisi: Divisi): void {
    this.divisiService.deleteDivisi(divisi.idDivisi)
      .subscribe( data => {
        this.divisis = this.divisis.filter(u => u !== divisi);
      })
  };

  editDivisi(divisi: Divisi): void {
    localStorage.removeItem("editDivisiId");
    localStorage.setItem("editDivisiId", divisi.idDivisi.toString());
    this.router.navigate(['edit-divisi']);
  };

  addDivisi(): void {
    this.router.navigate(['add-divisi']);
  };

  listJabatan(): void {
    this.router.navigate(['list-jabatan']);
  };

  listKaryawan(): void {
    this.router.navigate(['list-user']);
  };

  listDivisi(): void {
    this.router.navigate(['list-divisi']);
  };
}
