package com.militar.rest.AMB_DASHBOARD.dto.course;

import com.militar.rest.AMB_DASHBOARD.model.Curso;
import lombok.Builder;

import java.util.List;

@Builder
public record GetCourseSo(

       String idcurso,
         String nombre_curso,
       String precio,
       String dias

) {

    public static GetCourseSo from (Curso curso) {

        return GetCourseSo.builder()
                .idcurso(curso.getCurso_id().toString())
                .nombre_curso(curso.getNombreCurso())
                .precio(curso.getPrecio().toString())
                .dias(curso.getDias().toString())
                .build();

    }
}
