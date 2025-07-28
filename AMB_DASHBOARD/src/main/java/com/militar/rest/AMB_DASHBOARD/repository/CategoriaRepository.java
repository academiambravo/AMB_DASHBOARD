package com.militar.rest.AMB_DASHBOARD.repository;

import com.militar.rest.AMB_DASHBOARD.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria , Integer> {

    Optional<Categoria> findByNombre(String nombre);

}
