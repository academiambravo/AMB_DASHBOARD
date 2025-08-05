package com.militar.rest.AMB_DASHBOARD.dto.category;

import com.militar.rest.AMB_DASHBOARD.model.Categoria;
import lombok.Builder;

@Builder
public record UpdateCategoryDto(

        String category_name,
        String question_time,
        String modification_date
) {
    public static UpdateCategoryDto from (Categoria newCategoria) {
        return UpdateCategoryDto.builder()
                .category_name(newCategoria.getNombre())
                .question_time(newCategoria.getTiempo_pregunta())
                .modification_date(newCategoria.getFecha_modificacion())
                .build();
    }
}
