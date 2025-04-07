package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PELICULA")
public class PeliculaEntity {
    @Id
    @Column(name = "ID_PELICULA")
    private Long id;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "ANIO")
    private int anio;

    @Column(name = "DIRECTOR")
    private String director;

    @Column(name = "GENERO")
    private String genero;

    @Column(name = "sinopsis")
    private String sinopsis;
}
