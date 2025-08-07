package com.militar.rest.AMB_DASHBOARD.repository;

import com.militar.rest.AMB_DASHBOARD.model.Compra;
import com.militar.rest.AMB_DASHBOARD.model.Usuario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompraRepository extends JpaRepository<Compra , Integer> {


    List<Compra> findAllByUsuario(Usuario usuario);
}
