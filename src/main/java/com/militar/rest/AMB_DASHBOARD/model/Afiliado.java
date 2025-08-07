package com.militar.rest.AMB_DASHBOARD.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Afiliado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer affiliate_id;

    private String usuario ;
    private String contrasena;
    private String codigo;
    private String desc_afil_arcade;
    private String desc_alum_arcade;
    private String desc_afil_campana;
    private String desc_alum_campana;
    private Timestamp fecha_fin;
    private Integer usos;
    private Date fecha_creacion;
}
