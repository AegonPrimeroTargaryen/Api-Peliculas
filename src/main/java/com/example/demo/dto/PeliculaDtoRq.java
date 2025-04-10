package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeliculaDtoRq {
    @NotNull(message = "No puede ser null")
    @Size(min = 5, max = 100, message = "Rango de caracteres es de 5 a 100")
    @JsonProperty("titulo")
    private String titulo;

    @Min(value = 1000, message = "Año de 4 digitos")
    @Max(value = 9999, message = "Año maximo de 4 digitos")
    @JsonProperty("anio")
    private int anio;

    @NotNull(message = "No puede ser null")
    @Size(min = 5, max = 100, message = "Rango de caracteres es de 5 a 100")
    @Pattern(regexp = "^[\\p{L}\\s]+$", message = "Solo se permite texto")
    @JsonProperty("director")
    private String director;

    @NotNull(message = "No puede ser null")
    @Size(min = 5, max = 50, message = "Rango de caracteres es de 5 a 50")
    @Pattern(regexp = "^[\\p{L}\\s]+$", message = "Solo se permite texto")
    @JsonProperty("genero")
    private String genero;

    @NotNull(message = "No puede ser null")
    @Size(min = 5, max = 350, message = "Rango de caracteres es de 5 a 350")
    @JsonProperty("sinopsis")
    private String sinopsis;
}
