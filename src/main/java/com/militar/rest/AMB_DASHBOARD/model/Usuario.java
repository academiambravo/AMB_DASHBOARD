package com.militar.rest.AMB_DASHBOARD.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString(exclude = "tokens")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuario_id;


    private String correo;
    private String contrasena;
    private String nombre;
    private String apellidos;
    private String nombre_completo;
    private String ano_nacimiento;
    private String prefijo;
    private Integer telefono;
    private String direccion;
    private String apodo;
    private String foto;
    private String genero;
    private Date fecha_creacion;
    private Date ultimo_acceso;
    private String discord;
    private String ident_fiscal;
    private Boolean verificado;
    private String fecha_examen;
    private Integer aciertos_examen;
    private float nota_examen;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Token> tokens = new ArrayList<>();
}
