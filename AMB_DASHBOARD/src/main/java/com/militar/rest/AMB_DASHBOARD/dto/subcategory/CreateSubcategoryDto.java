package com.militar.rest.AMB_DASHBOARD.dto.subcategory;

import com.militar.rest.AMB_DASHBOARD.model.Subcategoria;
import lombok.Builder;

@Builder
public record CreateSubcategoryDto(
        String category_id,
        String name,
        boolean active,
        String created_at
) {


    public static CreateSubcategoryDto from (Subcategoria subcategoria) {
        return CreateSubcategoryDto.builder()
                .category_id(subcategoria.getCategoria().getCategoria_id().toString())
                .name(subcategoria.getNombre())
                .active(subcategoria.isHabilitada())
                .created_at(subcategoria.getFecha_creacion())
                .build();
    }
}
