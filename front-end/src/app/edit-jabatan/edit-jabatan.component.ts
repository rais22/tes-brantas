import { Component, OnInit } from '@angular/core';
import {JabatanService} from "../service/jabatan.service";
import {Router} from "@angular/router";
import {Jabatan} from "../model/jabatan.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {first} from "rxjs/operators";

@Component({
  selector: 'app-edit-jabatan',
  templateUrl: './edit-jabatan.component.html',
  styleUrls: ['./edit-jabatan.component.css']
})
export class EditJabatanComponent implements OnInit {

  jabatan: Jabatan;
  editForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private router: Router, private jabatanService: JabatanService) { }

  ngOnInit() {
    let jabatanId = localStorage.getItem("editJabatanId");
    if(!jabatanId) {
      alert("Invalid action.")
      this.router.navigate(['list-jabatan']);
      return;
    }
    this.editForm = this.formBuilder.group({
      idJabatan: [],
      namaJabatan: ['', Validators.required]
    });
    this.jabatanService.getJabatanByIdJabatan(+jabatanId)
      .subscribe( data => {
        this.editForm.setValue(data);
      });
  }

  onSubmit() {
    this.jabatanService.updateJabatan(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate(['list-jabatan']);
        },
        error => {
          alert(error.error.message);
          //alert(JSON.stringify(error));
        });
  }

}
