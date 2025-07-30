package com.militar.rest.AMB_DASHBOARD.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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


    @OneToMany( fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    private List<Curso> cursos;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String precio_compra;
    private String fecha_compra;
}
