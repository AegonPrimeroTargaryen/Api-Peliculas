package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeliculaDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("titulo")
    private String titulo;

    @JsonProperty("año")
    private int anio;

    @JsonProperty("director")
    private String director;

    @JsonProperty("genero")
    private String genero;

    @JsonProperty("sinopsis")
    private String sinopsis;
}
