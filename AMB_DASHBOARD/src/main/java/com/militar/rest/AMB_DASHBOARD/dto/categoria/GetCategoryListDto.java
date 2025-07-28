package com.militar.rest.AMB_DASHBOARD.dto.categoria;

import com.militar.rest.AMB_DASHBOARD.model.Categoria;
import lombok.Builder;

import java.util.List;

@Builder
public record GetCategoryListDto(

        List<GetCategoriaDto> categories
) {

    public static GetCategoryListDto getCategories(List <Categoria> categories) {
        return GetCategoryListDto.builder()
                .categories(categories.stream().map(GetCategoriaDto::from ).toList())
                .build();
    }
}
