import { Component, OnInit } from '@angular/core';
import {UserService} from "../service/user.service";
import {JabatanService} from "../service/jabatan.service";
import {DivisiService} from "../service/divisi.service";
import {Router} from "@angular/router";
import {User} from "../model/user.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {first} from "rxjs/operators";

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

  user: User;
  editForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private router: Router, private userService: UserService, private jabatanService: JabatanService, private divisiService: DivisiService) { }

  ngOnInit() {
    let userId = localStorage.getItem("editUserId");
    if(!userId) {
      alert("Invalid action.")
      this.router.navigate(['list-user']);
      return;
    }

     this.jabatanService.getJabatans()
      .subscribe( data => {
        this.jabatans = data;
      });

    this.divisiService.getDivisis()
      .subscribe( data => {
        this.divisis = data;
      });

    this.editForm = this.formBuilder.group({
      id: [],
      name: ['', Validators.required],
      age: ['', Validators.required],
      jabatan: ['', Validators.required],
      divisi: ['', Validators.required],
      active: ['', Validators.required]
    });
    
    this.userService.getUserById(+userId)
      .subscribe( data => {
        this.editForm.setValue(data);
      });
  }

  onSubmit() {
    this.userService.updateUser(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate(['list-user']);
        },
        error => {
          alert(error.error.message);
          //alert(JSON.stringify(error));
        });
  }

}
