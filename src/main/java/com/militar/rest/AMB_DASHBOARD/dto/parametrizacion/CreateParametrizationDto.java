package com.militar.rest.AMB_DASHBOARD.dto.parametrizacion;

import com.militar.rest.AMB_DASHBOARD.model.Parametrizacion;
import lombok.Builder;

@Builder
public record CreateParametrizationDto(

        String key,
        Integer value

) {
    public static CreateParametrizationDto from (Parametrizacion parametrization) {
        return CreateParametrizationDto.builder()
                .key(parametrization.getClave())
                .value(parametrization.getValor())
                .build();
    }
}
