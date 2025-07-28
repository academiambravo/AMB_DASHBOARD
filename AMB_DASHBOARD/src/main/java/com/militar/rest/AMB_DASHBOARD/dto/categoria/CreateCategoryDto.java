package com.militar.rest.AMB_DASHBOARD.dto.categoria;

import com.militar.rest.AMB_DASHBOARD.model.Categoria;
import lombok.Builder;

@Builder
public record CreateCategoryDto(

        String name,
        String questionTime,
        String createdBy,
        String creationDate

) {

    public static CreateCategoryDto from (Categoria categoria) {
        return CreateCategoryDto.builder()
                .name(categoria.getNombre())
                .questionTime(categoria.getTiempo_pregunta())
                .createdBy(categoria.getUsuario_creacion())
                .creationDate(categoria.getFecha_creacion())
                .build();
    }
}
