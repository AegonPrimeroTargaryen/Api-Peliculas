package com.example.demo.service.impl;

import com.example.demo.dto.PeliculaDto;
import com.example.demo.dto.PeliculaDtoRp;
import com.example.demo.dto.PeliculaDtoRq;
import com.example.demo.entity.PeliculaEntity;
import com.example.demo.exception.ControlExcepcion;
import com.example.demo.repository.PeliculaRespository;
import com.example.demo.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<PeliculaDtoRp> obtenerPeliculas() {
        List<PeliculaDto> listPeliculas = new ArrayList<>();

        List<PeliculaEntity> peliculaEntityList = peliculaRespository.findAll(
                Sort.by(Sort.Direction.ASC, "id")
        );
        peliculaEntityList.forEach(element -> listPeliculas.add(new PeliculaDto(Math.toIntExact(element.getId()),
                element.getTitulo(), element.getAnio(), element.getDirector(), element.getGenero(),
                element.getSinopsis())));

        return ResponseEntity.ok(setPeliculaDtoRp(listPeliculas));
    }

    @Override
    public ResponseEntity<PeliculaDtoRp> buscarPeliculaById(int id) {
        Optional<PeliculaEntity> result = peliculaRespository.findById((long) id);
        List<PeliculaDto> listPeliculas = new ArrayList<>();
        result.ifPresent(peliculaEntity -> listPeliculas.add(new PeliculaDto(
                Math.toIntExact(peliculaEntity.getId()), peliculaEntity.getTitulo(), peliculaEntity.getAnio(),
                peliculaEntity.getDirector(), peliculaEntity.getGenero(), peliculaEntity.getSinopsis())));

        return ResponseEntity.ok(setPeliculaDtoRp(listPeliculas));
    }

    @Override
    public ResponseEntity<PeliculaDtoRp> insertarPelicula(PeliculaDtoRq rq){
        return new ResponseEntity<>(setPeliculaDtoRp(peliculaRespository.save(setPeliculaEntity(rq))),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PeliculaDtoRp> eliminarPelicula(int id) throws ControlExcepcion{
        Optional<PeliculaEntity> result = peliculaRespository.findById((long) id);
        if(result.isEmpty()){
            throw new ControlExcepcion();
        }
        peliculaRespository.delete(result.get());
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<PeliculaDtoRp> actualizarPelicula(int id, PeliculaDtoRq rq) throws ControlExcepcion{
        Optional<PeliculaEntity> result = peliculaRespository.findById((long) id);
        if(result.isEmpty()){
            throw new ControlExcepcion();
        }
        PeliculaEntity peliculaEntity = setPeliculaEntity(rq);
        peliculaEntity.setId((long) id);
        return ResponseEntity.ok(setPeliculaDtoRp(peliculaRespository.save(peliculaEntity)));
    }

    private PeliculaDtoRp setPeliculaDtoRp(List<PeliculaDto> list){
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

    private PeliculaDtoRp setPeliculaDtoRp(PeliculaEntity peliculaEntity){
        List<PeliculaDto> listPeliculas = new ArrayList<>();
        listPeliculas.add(new PeliculaDto(Math.toIntExact(peliculaEntity.getId()), peliculaEntity.getTitulo(),
                peliculaEntity.getAnio(), peliculaEntity.getDirector(), peliculaEntity.getGenero(),
                peliculaEntity.getSinopsis()));
        return setPeliculaDtoRp(listPeliculas);
    }
}
