package com.militar.rest.AMB_DASHBOARD.dto.course;

import com.militar.rest.AMB_DASHBOARD.model.Curso;
import lombok.Builder;

import java.util.List;

@Builder
public record GetCourseSo(

        List<String> course_name

) {

    public static GetCourseSo from (List<Curso> curso) {
        return GetCourseSo.builder()
                .course_name(curso.stream()
                        .map(Curso::getNombreCurso)
                        .toList())
                .build();
    }
}
