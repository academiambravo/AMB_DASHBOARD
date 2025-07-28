package com.militar.rest.AMB_DASHBOARD.model;

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
public class UsuarioIP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuario_ip_id;

    /*
    private int idusuario;

     */
    private String ip;

}
