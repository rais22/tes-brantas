import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../service/user.service";
import {JabatanService} from "../service/jabatan.service";
import {DivisiService} from "../service/divisi.service";
import {first} from "rxjs/operators";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {
  
  jabatans: Jabatan[];
  divisis: Divisi[];

  constructor(private formBuilder: FormBuilder,private router: Router, private userService: UserService, private jabatanService: JabatanService, private divisiService: DivisiService) { }

  addForm: FormGroup;

  ngOnInit() {

    this.jabatanService.getJabatans()
      .subscribe( data => {
        this.jabatans = data;
      });

    this.divisiService.getDivisis()
      .subscribe( data => {
        this.divisis = data;
      });


    this.addForm = this.formBuilder.group({
      id: [],
      name: ['', Validators.required],
      age: ['', Validators.required],
      jabatan: ['', Validators.required],
      divisi: ['', Validators.required],
      active: ['', Validators.required]
    });

  }

  onSubmit() {
    this.userService.createUser(this.addForm.value)
      .subscribe( data => {
        this.router.navigate(['list-user']);
      },
      error => {
          alert(error.error.message);
          //alert(JSON.stringify(error));
        });
  }

}
