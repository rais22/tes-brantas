import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {JabatanService} from "../service/jabatan.service";
import {Jabatan} from "../model/jabatan.model";

@Component({
  selector: 'app-list-jabatan',
  templateUrl: './list-jabatan.component.html',
  styleUrls: ['./list-jabatan.component.css']
})
export class ListJabatanComponent implements OnInit {

  jabatans: Jabatan[];

  constructor(private router: Router, private jabatanService: JabatanService) { }

  ngOnInit() {
    this.jabatanService.getJabatans()
      .subscribe( data => {
        this.jabatans = data;
      });
  }

  deleteJabatan(jabatan: Jabatan): void {
    this.jabatanService.deleteJabatan(jabatan.idJabatan)
      .subscribe( data => {
        this.jabatans = this.jabatans.filter(u => u !== jabatan);
      })
  };

  editJabatan(jabatan: Jabatan): void {
    localStorage.removeItem("editJabatanId");
    localStorage.setItem("editJabatanId", jabatan.idJabatan.toString());
    this.router.navigate(['edit-jabatan']);
  };

  addJabatan(): void {
    this.router.navigate(['add-jabatan']);
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
