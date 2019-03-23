import { Component, OnInit } from '@angular/core';
import {DivisiService} from "../service/divisi.service";
import {Router} from "@angular/router";
import {Divisi} from "../model/divisi.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {first} from "rxjs/operators";

@Component({
  selector: 'app-edit-divisi',
  templateUrl: './edit-divisi.component.html',
  styleUrls: ['./edit-divisi.component.css']
})
export class EditDivisiComponent implements OnInit {

  divisi: Divisi;
  editForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private router: Router, private divisiService: DivisiService) { }

  ngOnInit() {
    let divisiId = localStorage.getItem("editDivisiId");
    if(!divisiId) {
      alert("Invalid action.")
      this.router.navigate(['list-divisi']);
      return;
    }
    this.editForm = this.formBuilder.group({
      idDivisi: [],
      namaDivisi: ['', Validators.required]
    });
    this.divisiService.getDivisiByIdDivisi(+divisiId)
      .subscribe( data => {
        this.editForm.setValue(data);
      });
  }

  onSubmit() {
    this.divisiService.updateDivisi(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate(['list-divisi']);
        },
        error => {
          alert(error.error.message);
          //alert(JSON.stringify(error));
        });
  }

}
