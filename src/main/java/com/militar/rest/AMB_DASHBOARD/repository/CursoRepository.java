package com.militar.rest.AMB_DASHBOARD.repository;

import com.militar.rest.AMB_DASHBOARD.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso , Integer> {

    Optional<Curso> findByNombreCurso(String nombreCurso);}
