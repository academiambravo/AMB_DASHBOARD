package com.militar.rest.AMB_DASHBOARD.model;


import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;


@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "usuario")
public class Token {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int token_id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;


    private String random;
    private Timestamp data_created;
    private Timestamp data_end;
    private boolean used;
}
