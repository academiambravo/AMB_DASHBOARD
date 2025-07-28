package com.militar.rest.AMB_DASHBOARD.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PreguntaExamen {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pregunta_examen_id;

    private boolean rcorrecta;
    private boolean rfalsa1;
    private boolean rfalsa2;
    private boolean rfalsa3;


    /*
    private int idcategoria;
    private int idsubcategoria;
    @Column(name = "idexamen")
    private int idexamen;
    @Column(name = "idpregunta")
    private int idpregunta;
     */
}
