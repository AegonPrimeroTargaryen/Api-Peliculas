package com.example.demo.service;

import com.example.demo.dto.PeliculaDtoRp;
import org.springframework.http.ResponseEntity;

public interface PeliculaService {
    ResponseEntity<PeliculaDtoRp> getListPeliculas();
    ResponseEntity<PeliculaDtoRp> getPeliculaById(int id);
}
