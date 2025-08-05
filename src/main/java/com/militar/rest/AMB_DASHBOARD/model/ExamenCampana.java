package com.militar.rest.AMB_DASHBOARD.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamenCampana {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int examen_campana_id;

    /*

    private int iduser;
    private int idcategoria;
     */


    @Enumerated(EnumType.STRING)
    private TipoExamen tipo_examen;
    private int preguntas_total;
    private int preguntas_acertadas;
    private int preguntas_falladas;
    private String usuario_creacion;
    private String fecha_examen;
}
