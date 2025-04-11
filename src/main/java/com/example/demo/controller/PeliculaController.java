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

    @GetMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<PeliculaDtoRp> obtenerPeliculas() {
        return peliculaService.obtenerPeliculas();
    }

    @GetMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PeliculaDtoRp> buscarPeliculaById(
            @PathVariable int id) {
        return peliculaService.buscarPeliculaById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<PeliculaDtoRp> insertarPelicula(@RequestBody @Valid PeliculaDtoRq rq){
        return peliculaService.insertarPelicula(rq);
    }

    @DeleteMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PeliculaDtoRp> eliminarPelicula(@PathVariable int id) {
        return peliculaService.eliminarPelicula(id);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PeliculaDtoRp> actualizarPelicula(@PathVariable int id, @RequestBody @Valid PeliculaDtoRq rq){
        return peliculaService.actualizarPelicula(id, rq);
    }
}
