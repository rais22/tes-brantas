package com.example.jdbc.demo.controller;


import com.example.jdbc.demo.model.Divisi;
import com.example.jdbc.demo.model.DivisiResult;
import com.example.jdbc.demo.service.DivisiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("divisi")
public class DivisiController {
    @Autowired
    DivisiService divisiService;

    @GetMapping("/{id_divisi}")
    public ResponseEntity<DivisiResult> getByIdDivisi(@PathVariable("id_divisi") int id_divisi) {
        DivisiResult divisi = divisiService.getDivisiByIdDivisi(id_divisi);
        return new ResponseEntity<DivisiResult>(divisi, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<DivisiResult>> getAll() {
        List<DivisiResult> listDivisi = divisiService.getAll();
        return new ResponseEntity<List<DivisiResult>>(listDivisi, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<List<DivisiResult>> addDivisi(@RequestBody Divisi divisi) {
        divisiService.addDivisi(divisi);
        List<DivisiResult> listDivisi = divisiService.getAll();
        return new ResponseEntity<List<DivisiResult>>(listDivisi, HttpStatus.OK);
    }

    @PutMapping("/{id_divisi}")
    public ResponseEntity<DivisiResult> updateDivisi(@PathVariable("id_divisi") int id_divisi, @RequestBody Divisi divisi) {
        divisiService.updateDivisi(divisi, id_divisi);
        DivisiResult divisi2 = divisiService.getDivisiByIdDivisi(id_divisi);
        return new ResponseEntity<DivisiResult>(divisi2, HttpStatus.OK);
    }

    @DeleteMapping("/{id_divisi}")
    public ResponseEntity<DivisiResult> deleteDivisi(@PathVariable("id_divisi") int id_divisi) {
    	DivisiResult divisi2 = divisiService.getDivisiByIdDivisi(id_divisi);
        divisiService.deleteDivisiByIdDivisi(id_divisi);
        return new ResponseEntity<DivisiResult>(divisi2, HttpStatus.OK);
    }
}