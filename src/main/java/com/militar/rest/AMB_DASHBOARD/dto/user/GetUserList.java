package com.militar.rest.AMB_DASHBOARD.dto.user;

import com.militar.rest.AMB_DASHBOARD.model.Usuario;
import lombok.Builder;

import java.util.List;

@Builder
public record GetUserList(
         List<GetUserDto> userList
        ) {

    public static GetUserList from (List<Usuario> users) {

        return GetUserList.builder()
                .userList(users.stream()
                        .map(GetUserDto::from)
                        .toList())
                .build();
    }

}
