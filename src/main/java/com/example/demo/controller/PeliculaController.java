package com.example.demo.controller;

import com.example.demo.dto.PeliculaDtoRp;
import com.example.demo.dto.PeliculaDtoRq;
import com.example.demo.service.PeliculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {
    private final PeliculaService peliculaService;

    @Autowired
    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public ResponseEntity<PeliculaDtoRp> obtenerPeliculas() {
        return peliculaService.getListPeliculas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaDtoRp> buscarPeliculaById(
            @PathVariable int id) {
        return peliculaService.getPeliculaById(id);
    }

    @PostMapping
    public ResponseEntity<PeliculaDtoRp> insertarPelicula(@RequestBody @Valid PeliculaDtoRq rq){
        return peliculaService.insertarPelicula(rq);
    }
}
