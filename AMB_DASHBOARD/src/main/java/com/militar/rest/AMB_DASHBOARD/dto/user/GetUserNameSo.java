package com.militar.rest.AMB_DASHBOARD.dto.user;

import com.militar.rest.AMB_DASHBOARD.model.Usuario;
import lombok.Builder;

import java.util.List;

@Builder
public record GetUserNameSo(

       Integer iduser,
       String correo,
       String nombre_completo,
       String apodo
){
    public static GetUserNameSo from (List<Usuario> user) {
        return GetUserNameSo.builder()
                .iduser(user.get(0).getUsuario_id())
                .correo(user.get(0).getCorreo())
                .nombre_completo(user.get(0).getNombre_completo())
                .apodo(user.get(0).getApodo())
                .build();
    }
}


