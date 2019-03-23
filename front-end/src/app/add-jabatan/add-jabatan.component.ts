import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {JabatanService} from "../service/jabatan.service";
import {first} from "rxjs/operators";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-jabatan',
  templateUrl: './add-jabatan.component.html',
  styleUrls: ['./add-jabatan.component.css']
})
export class AddJabatanComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,private router: Router, private jabatanService: JabatanService) { }

  addForm: FormGroup;

  ngOnInit() {

    this.addForm = this.formBuilder.group({
      id: [],
      namaJabatan: ['', Validators.required]
    });

  }

  onSubmit() {
    this.jabatanService.createJabatan(this.addForm.value)
      .subscribe( data => {
        this.router.navigate(['list-jabatan']);
      },
      error => {
          alert(error.error.message);
          //alert(JSON.stringify(error));
        });
  }

}
