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
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoria_id;
    private String nombre;
    private String tiempo_pregunta;
    private String usuario_creacion;
    private String fecha_creacion;
    private String usuario_modificacion;
    private String fecha_modificacion;
}
