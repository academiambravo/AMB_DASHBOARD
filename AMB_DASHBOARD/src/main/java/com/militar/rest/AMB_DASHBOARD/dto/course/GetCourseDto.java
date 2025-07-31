package com.militar.rest.AMB_DASHBOARD.dto.course;

import com.militar.rest.AMB_DASHBOARD.model.Curso;
import lombok.Builder;

@Builder
public record GetCourseDto(
        String course_id,
        String course_name,
        String course_price,
        String course_description,
        String course_days,
        String created_at,
        String created_by,
        String course_start,
        String course_end,
        boolean enabled,
        String mode
) {

    public static GetCourseDto from(Curso curso) {
        return GetCourseDto.builder()
                .course_id(curso.getCurso_id() != null ? curso.getCurso_id().toString() : "null")
                .course_name(curso.getNombreCurso())
                .course_price(curso.getPrecio() != null ? curso.getPrecio().toString() : "null")
                .course_description(curso.getDescripcion())
                .course_days(curso.getDias() != null ? curso.getDias().toString() : "null")
                .created_at(curso.getFecha_creacion() != null ? curso.getFecha_creacion() : "null")
                .created_by(curso.getUsuario_creacion())
                .course_start(curso.getFecha_inicio() != null ? curso.getFecha_inicio().toString() : "null")
                .course_end(curso.getFecha_fin() != null ? curso.getFecha_fin().toString() : "null")
                .enabled(curso.isHabilitado())
                .mode(curso.getModo())
                .build();
    }
}
