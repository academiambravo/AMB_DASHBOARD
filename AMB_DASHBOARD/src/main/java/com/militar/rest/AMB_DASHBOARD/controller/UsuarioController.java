package com.militar.rest.AMB_DASHBOARD.controller;

import com.militar.rest.AMB_DASHBOARD.dto.user.GetUserDto;
import com.militar.rest.AMB_DASHBOARD.dto.user.GetUserList;
import com.militar.rest.AMB_DASHBOARD.dto.user.GetUserNameSo;
import com.militar.rest.AMB_DASHBOARD.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Operation(
        summary = "Get user by ID",
        description = "Retrieve a user by their unique ID. Returns user details if found, otherwise throws an error.",
        tags = {"User"}
    )
    @GetMapping("/{id}")
    public ResponseEntity<GetUserDto> getUserById (@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getUserById(id));
    }

    @Operation(
        summary = "Get list of users",
        description = "Retrieve a list of all users. Returns a list of user details if found, otherwise throws an error.",
        tags = {"User"}
    )
    @GetMapping("/list")
    public ResponseEntity<GetUserList> getUserList () {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getUserList());
    }

    @Operation(
        summary = "Delete user by ID",
        description = "Delete a user by their unique ID. Returns no content if successful, otherwise throws an error.",
        tags = {"User"}
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById (@PathVariable Integer id) {
        usuarioService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/so-user")
    public ResponseEntity<GetUserNameSo> getUserByName() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getUserByName());
    }
}
