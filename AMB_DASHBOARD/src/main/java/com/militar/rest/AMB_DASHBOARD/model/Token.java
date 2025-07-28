package com.militar.rest.AMB_DASHBOARD.model;


import jakarta.persistence.*;
import lombok.*;

import java.security.Timestamp;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Token {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int token_id;

    /*
    private int iduser;

     */
    private String random;
    private Timestamp data_created;
    private Timestamp data_end;
    private boolean used;
}
