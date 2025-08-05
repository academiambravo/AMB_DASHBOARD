package com.militar.rest.AMB_DASHBOARD.dto.user;

import com.militar.rest.AMB_DASHBOARD.model.Usuario;
import lombok.Builder;

import java.util.List;

@Builder
public record GetUserNameSo(

       String iduser,
       String correo,
       String nombre_completo,
       String apodo
){
    public static GetUserNameSo from(Usuario user) {
        return GetUserNameSo.builder()
                .iduser(user.getUsuario_id().toString())
                .correo(user.getCorreo())
                .nombre_completo(user.getNombre_completo())
                .apodo(user.getApodo())
                .build();
    }
}


