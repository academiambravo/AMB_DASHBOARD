package com.militar.rest.AMB_DASHBOARD.service;

import com.militar.rest.AMB_DASHBOARD.dto.user.GetUserDto;
import com.militar.rest.AMB_DASHBOARD.dto.user.GetUserList;
import com.militar.rest.AMB_DASHBOARD.model.Usuario;
import com.militar.rest.AMB_DASHBOARD.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    private UsuarioRepository usuarioRepository;
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        usuarioRepository = mock(UsuarioRepository.class);
        usuarioService = new UsuarioService(usuarioRepository);
    }

    @Test
    void getUserById_success() {
        Usuario usuario = new Usuario();
        usuario.setUsuario_id(1);
        usuario.setNombre("Carlitos");

        when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario));

        GetUserDto dto = usuarioService.getUserById(1);

        assertNotNull(dto);
        assertEquals("Carlitos", dto.nombre());
    }

    @Test
    void getUserById_notFound() {
        when(usuarioRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> usuarioService.getUserById(1));
    }

    @Test
    void getUserList_success() {
        Usuario usuario = new Usuario();
        usuario.setUsuario_id(1);
        usuario.setNombre("Carlitos");

        List<Usuario> usuarios = List.of(usuario);
        when(usuarioRepository.findAll()).thenReturn(usuarios);

        GetUserList listDto = usuarioService.getUserList();

        assertNotNull(listDto);

    }

    @Test
    void getUserList_empty() {
        when(usuarioRepository.findAll()).thenReturn(List.of());

        assertThrows(EntityNotFoundException.class, () -> usuarioService.getUserList());
    }

    @Test
    void deleteUserById_success() {
        doNothing().when(usuarioRepository).deleteById(1);

        assertDoesNotThrow(() -> usuarioService.deleteUserById(1));
        verify(usuarioRepository, times(1)).deleteById(1);
    }
}
