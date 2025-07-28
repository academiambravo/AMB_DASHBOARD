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
public class Parametrizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idparametrizacion;
    private String clave;
    private int valor;
}
