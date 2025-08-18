package com.militar.rest.AMB_DASHBOARD.dto.category;

import com.militar.rest.AMB_DASHBOARD.model.Categoria;
import lombok.Builder;

@Builder
public record GetCategoriaDto(

        Integer category_id,
        String category_name,
        String question_time,
        String user_creation,
        String creation_date,
        String user_modification,
        String modification_date


) {

    public static GetCategoriaDto from (Categoria categoria) {
        return GetCategoriaDto.builder()
                .category_id(categoria.getCategoria_id())
                .category_name(categoria.getNombre())
                .question_time(categoria.getTiempo_pregunta())
                .user_creation(categoria.getUsuario_creacion())
                .creation_date(categoria.getFecha_creacion())
                .user_modification(categoria.getUsuario_modificacion())
                .modification_date(categoria.getFecha_modificacion())

                .build();
    }
}
