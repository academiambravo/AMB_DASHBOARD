package com.militar.rest.AMB_DASHBOARD.dto.subcategory;

import com.militar.rest.AMB_DASHBOARD.model.Subcategoria;
import lombok.Builder;

@Builder
public record GetSubCategoryDto(

        String subcategory_id,
        String category_id,
        String subcategory_name,
         boolean active,
        String user_created,
        String user_updated,
        String date_created,
        String date_updated


) {

    public static GetSubCategoryDto from (Subcategoria subcategoria) {
        return GetSubCategoryDto.builder()
                .subcategory_id(subcategoria.getIdSubcategoria().toString())
                .category_id(subcategoria.getCategoria().getCategoria_id().toString())
                .subcategory_name(subcategoria.getNombre())
                .active(subcategoria.isHabilitada())
                .user_created(subcategoria.getUsuario_creacion())
                .user_updated(subcategoria.getUsuario_modificacion())
                .date_created(subcategoria.getFecha_creacion())
                .date_updated(subcategoria.getFecha_modificacion())
                .build();
    }
}
