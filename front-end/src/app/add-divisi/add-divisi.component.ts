import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {DivisiService} from "../service/divisi.service";
import {first} from "rxjs/operators";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-divisi',
  templateUrl: './add-divisi.component.html',
  styleUrls: ['./add-divisi.component.css']
})
export class AddDivisiComponent implements OnInit {

 constructor(private formBuilder: FormBuilder,private router: Router, private divisiService: DivisiService) { }

  addForm: FormGroup;

  ngOnInit() {

    this.addForm = this.formBuilder.group({
      id: [],
      namaDivisi: ['', Validators.required]
    });

  }

  onSubmit() {
    this.divisiService.createDivisi(this.addForm.value)
      .subscribe( data => {
        this.router.navigate(['list-divisi']);
      },
      error => {
          alert(error.error.message);
          //alert(JSON.stringify(error));
        });
  }

}
