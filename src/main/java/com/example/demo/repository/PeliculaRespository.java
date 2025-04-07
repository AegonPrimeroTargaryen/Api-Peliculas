package com.example.demo.repository;

import com.example.demo.entity.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRespository extends JpaRepository<PeliculaEntity, Long> {
}
