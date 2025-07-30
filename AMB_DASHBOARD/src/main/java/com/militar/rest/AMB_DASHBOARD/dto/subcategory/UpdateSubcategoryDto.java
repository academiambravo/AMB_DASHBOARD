package com.militar.rest.AMB_DASHBOARD.dto.subcategory;

import com.militar.rest.AMB_DASHBOARD.model.Subcategoria;
import lombok.Builder;

@Builder
public record UpdateSubcategoryDto(

        String category_id,
        String name,
        boolean active,
        String created_by,
        String updated_by,
        String created_at,
        String updated_at
) {

    public static UpdateSubcategoryDto from (Subcategoria subcategoria) {
        return UpdateSubcategoryDto.builder()
                .category_id(subcategoria.getCategoria().getCategoria_id().toString())
                .name(subcategoria.getNombre())
                .active(subcategoria.isHabilitada())
                .created_by(subcategoria.getUsuario_creacion())
                .updated_by(subcategoria.getUsuario_modificacion())
                .created_at(subcategoria.getFecha_creacion())
                .updated_at(subcategoria.getFecha_modificacion())
                .build();
    }
}
