package com.militar.rest.AMB_DASHBOARD.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.security.Timestamp;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Curso {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int curso_id;

    private String nombre_curso;
    private float precio;
    private String descripcion;
    private int dias;
    private String fecha_creacion;
    private String usuario_creacion;
    private Timestamp fecha_inicio;
    private Timestamp fecha_fin;
    private boolean habilitado;
    private String modo;
}
