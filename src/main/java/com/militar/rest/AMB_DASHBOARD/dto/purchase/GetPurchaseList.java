package com.militar.rest.AMB_DASHBOARD.dto.purchase;

import com.militar.rest.AMB_DASHBOARD.model.Compra;
import lombok.Builder;

import java.util.List;

@Builder
public record GetPurchaseList(

        List<GetPurchaseDto> purchases
) {

    public static GetPurchaseList from (List<Compra> compras) {

        return GetPurchaseList.builder()
                .purchases(compras.stream().map(GetPurchaseDto::from).toList())
                .build();
    }
}
