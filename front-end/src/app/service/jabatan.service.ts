import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Jabatan} from "../model/jabatan.model";

@Injectable()
export class JabatanService {
  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:8080/jabatan/';

  getJabatans() {

    return this.http.get<Jabatan[]>(this.baseUrl);
  }

  getJabatanByIdJabatan(id_jabatan: number) {
    return this.http.get<Jabatan>(this.baseUrl + '' + id_jabatan);
  }

  createJabatan(jabatan: Jabatan) {
    return this.http.post(this.baseUrl, jabatan);
  }

  updateJabatan(jabatan: Jabatan) {
    return this.http.put(this.baseUrl + '' + jabatan.idJabatan, jabatan);
  }

  deleteJabatan(id_jabatan: number) {
    return this.http.delete(this.baseUrl + '/' + id_jabatan);
  }
}
