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
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int comentario_id;

    /*
        private int idtarea;
    private int idusuario;
     */

    private String comentario;
    private Timestamp fecha_creacion;
}
