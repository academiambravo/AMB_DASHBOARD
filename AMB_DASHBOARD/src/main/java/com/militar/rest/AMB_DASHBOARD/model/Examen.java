package com.militar.rest.AMB_DASHBOARD.model;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int examen_id;

    /*
      private int iduser;
    private int idcategoria;

     */

    private int preguntas_total;
    private int preguntas_acertadas;
    private int preguntas_falladas;
    private String fecha_examen;

    @Enumerated(EnumType.STRING)
    private TipoExamen tipo_examen;
}
