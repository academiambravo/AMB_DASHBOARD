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

    public static GetCourseDto from (Curso curso) {
        return GetCourseDto.builder()
                .course_id(curso.getCurso_id().toString())
                .course_name(curso.getNombreCurso())
                .course_price(curso.getPrecio().toString())
                .course_description(curso.getDescripcion())
                .course_days(curso.getDias().toString())
                .created_at(curso.getFecha_creacion())
                .created_by(curso.getUsuario_creacion())
                .course_start(curso.getFecha_inicio().toString())
                .course_end(curso.getFecha_fin().toString())
                .enabled(curso.isHabilitado())
                .mode(curso.getModo())
                .build();
    }
}
