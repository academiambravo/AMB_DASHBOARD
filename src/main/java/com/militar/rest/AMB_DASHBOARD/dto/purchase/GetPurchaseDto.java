package com.militar.rest.AMB_DASHBOARD.dto.purchase;

import com.militar.rest.AMB_DASHBOARD.dto.user.GetUserDto;
import com.militar.rest.AMB_DASHBOARD.model.Compra;
import com.militar.rest.AMB_DASHBOARD.model.Curso;
import lombok.Builder;

import java.util.stream.Collectors;

@Builder
public record GetPurchaseDto(

        String purchase_id,
        String user_id,
        String full_name,
        String course_id,
        String course_name,
        String purchase_price,
        String purchase_date

) {

    public static GetPurchaseDto from (Compra c ) {

        return GetPurchaseDto.builder()

                .purchase_id(c.getCompra_id().toString())
                .user_id(c.getUsuario().getUsuario_id().toString())
                .full_name(c.getUsuario().getNombre_completo())
                .course_id(c.getCursos().stream().map(Curso::getCurso_id).map(String::valueOf).collect(Collectors.joining(", ")))
                .course_name(c.getCursos().stream().map(Curso::getNombreCurso).collect(Collectors.joining(", ")))
                .purchase_price(c.getPrecio_compra())
                .purchase_date(c.getFecha_compra())
                .build();

    }
}