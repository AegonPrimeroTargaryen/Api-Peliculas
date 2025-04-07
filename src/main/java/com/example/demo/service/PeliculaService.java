package com.example.demo.service;

import com.example.demo.dto.PeliculaDto;
import com.example.demo.dto.PeliculaDtoRp;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeliculaService {
    private List<PeliculaDto> listPeliculas = new ArrayList<>();

    public PeliculaService() {
        this.listPeliculas.add(new PeliculaDto(
                1,"El Viaje del Tiempo",
                2019,
                "Sofía Ramírez",
                "Ciencia Ficción",
                "Un grupo de científicos descubre una anomalía en el espacio-tiempo que les permite viajar al pasado, pero pronto se dan cuenta de que sus acciones pueden alterar el futuro de maneras impredecibles."));
        this.listPeliculas.add(new PeliculaDto(
                2,
                "Bajo la Tormenta",
                2021,
                "Javier Paredes",
                "Drama",
                "Un hombre regresa a su pueblo natal tras 20 años para enfrentar los errores de su pasado y reencontrarse con su familia, mientras una tormenta amenaza con destruir todo a su paso."));
        this.listPeliculas.add(new PeliculaDto(
                3,
                "Código Secreto",
                2019,
                "Lucía Fernández",
                "Thriller",
                "Un programador descubre un algoritmo oculto en una base de datos gubernamental que puede descifrar cualquier código. Ahora, es perseguido por una agencia secreta que quiere eliminarlo antes de que revele la verdad."));
        this.listPeliculas.add(new PeliculaDto(
                4,
                "La Herencia Maldita",
                2022,
                "Fernando López",
                "Terror",
                "Tras la muerte de su abuela, una joven hereda una antigua mansión con un oscuro secreto: un espíritu vengativo que reclama justicia por un crimen cometido hace décadas."));
        this.listPeliculas.add(new PeliculaDto(
                5,
                "Última Jugada",
                2020,
                "Martín Torres",
                "Acción",
                "Un exjugador de póker es obligado a participar en un torneo clandestino donde las apuestas no son solo dinero, sino también la vida de los participantes."));
        this.listPeliculas.add(new PeliculaDto(
                6,
                "Amor en la Toscana",
                2024,
                "Elena Suárez",
                "Romance",
                "Una escritora en crisis viaja a Italia para encontrar inspiración, pero termina descubriendo el amor en el lugar menos esperado."));
    }

    public ResponseEntity<PeliculaDtoRp> getListPeliculas() {
        PeliculaDtoRp response = new PeliculaDtoRp();
        response.setCodigo(0);
        response.setStatus("OK");
        response.setPeliculas(listPeliculas);

        return ResponseEntity.ok(response);
    }

    public PeliculaDtoRp getPeliculaById(int id) {
        PeliculaDtoRp peliculaDtoRps = new PeliculaDtoRp();
//        try {
//            peliculaDtoRps = listPeliculas.get(id - 1);
//        }catch (IndexOutOfBoundsException e) {
//            peliculaDtoRps = new PeliculaDtoRp();
//        }
        return peliculaDtoRps;
    }
}
