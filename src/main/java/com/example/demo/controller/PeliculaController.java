package com.example.demo.controller;

import com.example.demo.dto.PeliculaDtoRp;
import com.example.demo.repository.PeliculaRespository;
import com.example.demo.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {
    private final PeliculaService peliculaService;

    @Autowired
    public PeliculaController(PeliculaService peliculaService, PeliculaRespository peliculaRespository) {
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


}
