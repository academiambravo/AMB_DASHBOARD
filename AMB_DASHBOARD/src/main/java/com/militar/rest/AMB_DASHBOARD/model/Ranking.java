package com.militar.rest.AMB_DASHBOARD.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ranking_id;

    /*
        private Integer iduser;
        private Integer idcategoria;

     */

    @Enumerated(EnumType.STRING)
    private TipoExamen tipo_examen;
    
    
    private Integer preguntas_realizadas;
    private Integer preguntas_acertadas;
    private Integer preguntas_falladas;
    private float baremo;
}
