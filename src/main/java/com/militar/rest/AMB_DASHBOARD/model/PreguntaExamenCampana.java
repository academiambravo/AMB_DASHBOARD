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
public class PreguntaExamenCampana {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idexamen_pregunta_campana;


    /*
    private int idexamencampana;
    private int idpregunta;
    private int idcategoria;
    private int idsubcategoria;

     */
    private boolean rcorrecta;
    private boolean rfalsa1;
    private boolean rfalsa2;
    private boolean rfalsa3;

}
