package com.militar.rest.AMB_DASHBOARD.dto.course;

import com.militar.rest.AMB_DASHBOARD.model.Curso;
import lombok.Builder;

import java.util.List;

@Builder
public record GetCourseListDto(

        List<GetCourseDto> courses
) {

    public static GetCourseListDto from (List<Curso> list) {
        return GetCourseListDto.builder()
                .courses(list.stream()
                        .map(GetCourseDto::from)
                        .toList())
                .build();
    }
}
