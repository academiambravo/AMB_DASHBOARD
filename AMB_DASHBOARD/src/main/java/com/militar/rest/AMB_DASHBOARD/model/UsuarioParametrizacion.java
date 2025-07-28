package com.militar.rest.AMB_DASHBOARD.model;


import jakarta.persistence.*;
import lombok.*;

import java.security.Timestamp;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioParametrizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuario_parametrizacion_id;

    /*
    private int idusuario;

     */
    private String merchant_order;
    private Timestamp fecha_creacion;
    private Timestamp fecha_fin;
    private Boolean validado;
}
