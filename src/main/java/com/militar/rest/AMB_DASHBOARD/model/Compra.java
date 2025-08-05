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
    private Integer compra_id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "compra_curso",
            joinColumns = @JoinColumn(name = "compra_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursos;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String precio_compra;
    private String fecha_compra;
}