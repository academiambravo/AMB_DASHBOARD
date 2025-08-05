package com.militar.rest.AMB_DASHBOARD.dto.subcategory;

import com.militar.rest.AMB_DASHBOARD.model.Subcategoria;
import lombok.Builder;

import java.util.List;

@Builder
public record GetSubcategoryListDto(

        List<GetSubCategoryDto> subcategories
) {

    public static GetSubcategoryListDto getSubcategories(List<Subcategoria> subcategories) {

        return GetSubcategoryListDto.builder()
                .subcategories(subcategories.stream().map(GetSubCategoryDto::from).toList())
                .build();
    }


}
