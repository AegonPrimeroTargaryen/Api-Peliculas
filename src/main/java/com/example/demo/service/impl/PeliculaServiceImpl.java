package com.example.demo.service.impl;

import com.example.demo.dto.PeliculaDto;
import com.example.demo.dto.PeliculaDtoRp;
import com.example.demo.dto.PeliculaDtoRq;
import com.example.demo.entity.PeliculaEntity;
import com.example.demo.repository.PeliculaRespository;
import com.example.demo.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService {
    private final PeliculaRespository peliculaRespository;

    @Autowired
    public PeliculaServiceImpl(PeliculaRespository peliculaRespository) {
        this.peliculaRespository = peliculaRespository;
    }

    @Override
    public ResponseEntity<PeliculaDtoRp> getListPeliculas() {
        List<PeliculaDto> listPeliculas = new ArrayList<>();

        List<PeliculaEntity> peliculaEntityList = peliculaRespository.findAll(
                Sort.by(Sort.Direction.ASC, "id")
        );
        peliculaEntityList.forEach(element -> listPeliculas.add(new PeliculaDto(Math.toIntExact(element.getId()),
                element.getTitulo(), element.getAnio(), element.getDirector(), element.getGenero(),
                element.getSinopsis())));

        return ResponseEntity.ok(setResponse(listPeliculas));
    }

    @Override
    public ResponseEntity<PeliculaDtoRp> getPeliculaById(int id) {
        Optional<PeliculaEntity> result = peliculaRespository.findById((long) id);
        List<PeliculaDto> listPeliculas = new ArrayList<>();
        result.ifPresent(peliculaEntity -> listPeliculas.add(new PeliculaDto(
                Math.toIntExact(peliculaEntity.getId()), peliculaEntity.getTitulo(), peliculaEntity.getAnio(),
                peliculaEntity.getDirector(), peliculaEntity.getGenero(), peliculaEntity.getSinopsis())));

        return ResponseEntity.ok(setResponse(listPeliculas));
    }

    @Override
    public ResponseEntity<PeliculaDtoRp> insertarPelicula(PeliculaDtoRq rq){
        return ResponseEntity.ok(setPeliculaDto(peliculaRespository.save(setPeliculaEntity(rq))));
    }

    private PeliculaDtoRp setResponse(List<PeliculaDto> list){
        PeliculaDtoRp response = new PeliculaDtoRp();
        response.setCodigo(0);
        response.setStatus("OK");
        response.setPeliculas(list);
        return response;
    }

    private PeliculaEntity setPeliculaEntity(PeliculaDtoRq rq){
        PeliculaEntity peliculaEntity = new PeliculaEntity();
        peliculaEntity.setTitulo(rq.getTitulo());
        peliculaEntity.setAnio(rq.getAnio());
        peliculaEntity.setDirector(rq.getDirector());
        peliculaEntity.setGenero(rq.getGenero());
        peliculaEntity.setSinopsis(rq.getSinopsis());
        return peliculaEntity;
    }

    private PeliculaDtoRp setPeliculaDto(PeliculaEntity peliculaEntity){
        List<PeliculaDto> listPeliculas = new ArrayList<>();
        listPeliculas.add(new PeliculaDto(Math.toIntExact(peliculaEntity.getId()), peliculaEntity.getTitulo(),
                peliculaEntity.getAnio(), peliculaEntity.getDirector(), peliculaEntity.getGenero(),
                peliculaEntity.getSinopsis()));
        return setResponse(listPeliculas);
    }
}
