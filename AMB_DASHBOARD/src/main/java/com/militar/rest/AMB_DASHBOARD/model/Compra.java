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
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int compra_id;

    /*
    private int iduser;
    private int idcurso;
     */

    private String precio_compra;
    private String fecha_compra;
}
