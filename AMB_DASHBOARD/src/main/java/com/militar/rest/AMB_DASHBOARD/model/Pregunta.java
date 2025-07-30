package com.militar.rest.AMB_DASHBOARD.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pregunta_id;

    private String identificador;
    private Integer orden;
    private String enunciado;
    private String pregunta;
    private String rcorrecta;
    private String rfalsa1;
    private String rfalsa2;
    private String rfalsa3;
    private String foto;
    private String foto_pregunta;
    private String descripcion_respuesta;
    private String foto_respuesta;
    private String usuario_creacion;
    private String fecha_creacion;
    private String usuario_modificacion;
    private String fecha_modificacion;


    @ManyToOne
    @JoinColumn(name = "id_subcategoria")
    private Subcategoria subcategoria;
}
