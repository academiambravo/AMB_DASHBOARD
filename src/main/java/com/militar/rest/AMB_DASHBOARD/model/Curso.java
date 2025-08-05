package com.militar.rest.AMB_DASHBOARD.model;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Curso {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer curso_id;

    @Column(name = "nombre_curso")
    private String nombreCurso;
    private Double precio;
    private String descripcion;
    private Integer dias;
    private String fecha_creacion;
    private String usuario_creacion;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;
    private boolean habilitado;
    private String modo;
}
