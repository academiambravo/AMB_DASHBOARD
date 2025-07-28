package com.militar.rest.AMB_DASHBOARD.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tarea_id;

    /*
    private int idcampana;
        private int idexamen;


     */
    private String tipo;
    private String titulo_tarea;
    private String descripcion_tarea;
    private Integer puntos;
    private String enlace_video;
    private Date fecha_inicio;
    private Time hora_inicio;
    private Date fecha_entrega;
    private Time hora_entrega;
    private String usuario_creacion;
    private String fecha_creacion;
}
