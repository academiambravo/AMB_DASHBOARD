package com.militar.rest.AMB_DASHBOARD.model;

import jakarta.persistence.*;
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

    @ManyToOne
    private Usuario usuario;

    private String ip;

}
