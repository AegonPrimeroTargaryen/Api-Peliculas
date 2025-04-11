package com.example.demo.service;

import com.example.demo.dto.PeliculaDtoRp;
import com.example.demo.dto.PeliculaDtoRq;
import org.springframework.http.ResponseEntity;

public interface PeliculaService {
    ResponseEntity<PeliculaDtoRp> obtenerPeliculas();
    ResponseEntity<PeliculaDtoRp> buscarPeliculaById(int id);
    ResponseEntity<PeliculaDtoRp> insertarPelicula(PeliculaDtoRq rq);
    ResponseEntity<PeliculaDtoRp> eliminarPelicula(int id);
    ResponseEntity<PeliculaDtoRp> actualizarPelicula(int id, PeliculaDtoRq rq);
}
