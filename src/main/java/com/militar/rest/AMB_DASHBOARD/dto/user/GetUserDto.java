package com.militar.rest.AMB_DASHBOARD.dto.user;

import com.militar.rest.AMB_DASHBOARD.model.Usuario;
import lombok.Builder;

import java.util.Date;

@Builder
public record GetUserDto(
        String iduser,
        String correo,
        String contrasena,
        String nombre,
        String apellidos,
        String nombre_completo,
        String ano_nacimiento,
        String prefijo,
        String telefono,
        String direccion,
        String apodo,
        String foto,
        String genero,
        Date fecha_creacion,
        Date ultimo_acceso,
        String discord,
        String ident_fiscal,
        Boolean verificado,
        String fecha_examen,
        String aciertos_examen,
        String nota_examen,
        Boolean ips,
        String baremo
) {
    public static GetUserDto from(Usuario user) {
        return GetUserDto.builder()
                .iduser(user.getUsuario_id().toString())
                .correo(user.getCorreo())
                .contrasena(user.getContrasena())
                .nombre(user.getNombre())
                .apellidos(user.getApellidos())
                .nombre_completo(user.getNombre_completo())
                .ano_nacimiento(user.getAno_nacimiento())
                .prefijo(user.getPrefijo())
                .telefono(user.getTelefono().toString())
                .direccion(user.getDireccion())
                .apodo(user.getApodo())
                .foto(user.getFoto())
                .genero(user.getGenero())
                .fecha_creacion(user.getFecha_creacion())
                .ultimo_acceso(user.getUltimo_acceso())
                .discord(user.getDiscord())
                .ident_fiscal(user.getIdent_fiscal())
                .verificado(user.getVerificado())
                .fecha_examen(user.getFecha_examen())
                .aciertos_examen(user.getAciertos_examen().toString())
                .nota_examen(user.getNota_examen().toString())
                .baremo(user.getBaremo())
                .build();
    }
}