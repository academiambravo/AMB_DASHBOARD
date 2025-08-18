package com.militar.rest.AMB_DASHBOARD.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subcategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subcategoria")
    private Integer idSubcategoria;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    private String nombre;
    private String usuario_creacion;
    private String fecha_creacion;
    private String usuario_modificacion;
    private String fecha_modificacion;
    private boolean habilitada;
}