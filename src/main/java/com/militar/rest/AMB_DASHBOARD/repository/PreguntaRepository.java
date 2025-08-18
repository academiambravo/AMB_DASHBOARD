package com.militar.rest.AMB_DASHBOARD.repository;

import com.militar.rest.AMB_DASHBOARD.model.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PreguntaRepository extends JpaRepository<Pregunta , Integer> {
    List<Pregunta> findPreguntasBySubcategoria_IdSubcategoria(Integer idSubcategoria);
}