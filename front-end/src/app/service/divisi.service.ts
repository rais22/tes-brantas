import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Divisi} from "../model/divisi.model";

@Injectable()
export class DivisiService {
  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:8080/divisi/';

  getDivisis() {

    return this.http.get<Divisi[]>(this.baseUrl);
  }

  getDivisiByIdDivisi(id_divisi: number) {
    return this.http.get<Divisi>(this.baseUrl + '' + id_divisi);
  }

  createDivisi(divisi: Divisi) {
    return this.http.post(this.baseUrl, divisi);
  }

  updateDivisi(divisi: Divisi) {
    return this.http.put(this.baseUrl + '' + divisi.idDivisi, divisi);
  }

  deleteDivisi(id_divisi: number) {
    return this.http.delete(this.baseUrl + '/' + id_divisi);
  }
}
