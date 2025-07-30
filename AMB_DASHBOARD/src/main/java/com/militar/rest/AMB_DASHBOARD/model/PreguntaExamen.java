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



    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idsubcategoria")
    private Subcategoria subcategoria;

    @ManyToOne
    @JoinColumn(name = "idexamen")
    private Examen examen;

    @ManyToOne
    @JoinColumn(name = "idpregunta")
    private Pregunta pregunta;
}
