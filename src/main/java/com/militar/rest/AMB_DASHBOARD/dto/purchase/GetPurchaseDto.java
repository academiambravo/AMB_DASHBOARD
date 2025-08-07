package com.militar.rest.AMB_DASHBOARD.dto.purchase;

import com.militar.rest.AMB_DASHBOARD.dto.user.GetUserDto;
import com.militar.rest.AMB_DASHBOARD.model.Compra;
import com.militar.rest.AMB_DASHBOARD.model.Curso;
import lombok.Builder;

import java.util.stream.Collectors;

@Builder
public record GetPurchaseDto(

        String purchase_id,
        String discount_code,
        String merchant_order,
        String purchase_date,
        String start_date,
        String end_date,
        String user_id,
        String email,
        String first_name,
        String last_name,
        String nickname,
        String phone,
        String course_id,
        String description,
        String mode,
        String course_name,
        String purchase_price,
        String affiliate_billing
) {

    public static GetPurchaseDto from(Compra compra) {
        return GetPurchaseDto.builder()
                .purchase_id(String.valueOf(compra.getCompra_id()))
                .discount_code(compra.getCodigo_descuento())
                .merchant_order(compra.getMerchant_order())
                .purchase_date(String.valueOf(compra.getFecha_compra()))
                .start_date(String.valueOf(compra.getFecha_inicio()))
                .end_date(String.valueOf(compra.getFecha_fin()))
                .user_id(String.valueOf(compra.getUsuario().getUsuario_id()))
                .email(compra.getUsuario().getCorreo())
                .first_name(compra.getUsuario().getNombre())
                .last_name(compra.getUsuario().getApellidos())
                .nickname(compra.getUsuario().getApodo())
                .phone(String.valueOf(compra.getUsuario().getTelefono()))
                .course_id(compra.getCursos().isEmpty() ? null : String.valueOf(compra.getCursos().get(0).getCurso_id()))
                .description(compra.getCursos().isEmpty() ? null : compra.getCursos().get(0).getDescripcion())
                .mode(compra.getCursos().isEmpty() ? null : compra.getCursos().get(0).getModo())
                .course_name(compra.getCursos().isEmpty() ? null : compra.getCursos().get(0).getPrecio().toString())
                .purchase_price(String.valueOf(compra.getPrecio_compra()))
                .build();
    }

}