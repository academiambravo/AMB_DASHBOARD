package com.militar.rest.AMB_DASHBOARD.repository;

import com.militar.rest.AMB_DASHBOARD.model.Subcategoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubcategoriaRepository extends JpaRepository<Subcategoria, Integer> {

    Optional<Subcategoria> findByNombre(String name);
}
