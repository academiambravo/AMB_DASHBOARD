package com.militar.rest.AMB_DASHBOARD.dto.user;

import com.militar.rest.AMB_DASHBOARD.model.Usuario;
import lombok.Builder;

@Builder
public record GetUserDto(

        String user_id,
        String user_name,
        String user_phone,
        String user_email,
        boolean verified,
        String nickname,
        String last_login,
        String user_age

) {

    public static GetUserDto from (Usuario user) {

        return GetUserDto.builder()
                .user_id(user.getUsuario_id().toString())
                .user_name(user.getNombre())
                .user_phone(user.getTelefono().toString())
                .user_email(user.getCorreo())
                .verified(user.getVerificado())
                .nickname(user.getApodo())
                .last_login(user.getUltimo_acceso().toString())
                .user_age(user.getAno_nacimiento())
                .build();
    }
}
