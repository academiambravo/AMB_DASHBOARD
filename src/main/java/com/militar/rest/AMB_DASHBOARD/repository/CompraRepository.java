package com.militar.rest.AMB_DASHBOARD.repository;

import com.militar.rest.AMB_DASHBOARD.model.Compra;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra , Integer> {


}
