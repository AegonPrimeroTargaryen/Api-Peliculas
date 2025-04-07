package com.example.demo.controller;

import com.example.demo.dto.PeliculaDtoRp;
import com.example.demo.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;

    @Autowired
    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public ResponseEntity<PeliculaDtoRp> listPeliculas() {
        return peliculaService.getListPeliculas();
    }

    @GetMapping("/{id}")
    public PeliculaDtoRp getPeliculaById(
            @PathVariable int id) {
        return peliculaService.getPeliculaById(id);
    }
}
