package com.example.demo.service;

import com.example.demo.dto.PeliculaDtoRp;
import com.example.demo.dto.PeliculaDtoRq;
import com.example.demo.exception.ControlExcepcion;
import org.springframework.http.ResponseEntity;

public interface PeliculaService {
    ResponseEntity<PeliculaDtoRp> obtenerPeliculas();
    ResponseEntity<PeliculaDtoRp> buscarPeliculaById(int id);
    ResponseEntity<PeliculaDtoRp> insertarPelicula(PeliculaDtoRq rq);
    ResponseEntity<PeliculaDtoRp> eliminarPelicula(int id) throws ControlExcepcion;
    ResponseEntity<PeliculaDtoRp> actualizarPelicula(int id, PeliculaDtoRq rq) throws ControlExcepcion;
}
