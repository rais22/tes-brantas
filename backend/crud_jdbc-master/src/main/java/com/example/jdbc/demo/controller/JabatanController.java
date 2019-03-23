package com.example.jdbc.demo.controller;


import com.example.jdbc.demo.model.Jabatan;
import com.example.jdbc.demo.model.JabatanResult;
import com.example.jdbc.demo.service.JabatanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("jabatan")
public class JabatanController {
    @Autowired
    JabatanService jabatanService;

    @GetMapping("/{id_jabatan}")
    public ResponseEntity<JabatanResult> getByIdJabatan(@PathVariable("id_jabatan") int id_jabatan) {
        JabatanResult jabatan = jabatanService.getJabatanByIdJabatan(id_jabatan);
        return new ResponseEntity<JabatanResult>(jabatan, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<JabatanResult>> getAll() {
        List<JabatanResult> listJabatan = jabatanService.getAll();
        return new ResponseEntity<List<JabatanResult>>(listJabatan, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<List<JabatanResult>> addJabatan(@RequestBody Jabatan jabatan) {
        jabatanService.addJabatan(jabatan);
        List<JabatanResult> listJabatan = jabatanService.getAll();
        return new ResponseEntity<List<JabatanResult>>(listJabatan, HttpStatus.OK);
    }

    @PutMapping("/{id_jabatan}")
    public ResponseEntity<JabatanResult> updateJabatan(@PathVariable("id_jabatan") int id_jabatan, @RequestBody Jabatan jabatan) {
        jabatanService.updateJabatan(jabatan, id_jabatan);
        JabatanResult jabatan2 = jabatanService.getJabatanByIdJabatan(id_jabatan);
        return new ResponseEntity<JabatanResult>(jabatan2, HttpStatus.OK);
    }

    @DeleteMapping("/{id_jabatan}")
    public ResponseEntity<JabatanResult> deleteJabatan(@PathVariable("id_jabatan") int id_jabatan) {
        JabatanResult jabatan2 = jabatanService.getJabatanByIdJabatan(id_jabatan);
        jabatanService.deleteJabatanByIdJabatan(id_jabatan);
        return new ResponseEntity<JabatanResult>(jabatan2, HttpStatus.OK);
    }
}