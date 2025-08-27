package com.militar.rest.AMB_DASHBOARD.service;

import com.militar.rest.AMB_DASHBOARD.dto.user.GetUserDto;
import com.militar.rest.AMB_DASHBOARD.dto.user.GetUserList;
import com.militar.rest.AMB_DASHBOARD.dto.user.GetUserNameSo;
import com.militar.rest.AMB_DASHBOARD.model.Usuario;
import com.militar.rest.AMB_DASHBOARD.repository.UsuarioRepository;
import com.militar.rest.AMB_DASHBOARD.service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
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

    @Test
    void getUserByName_success() {
        Usuario usuario = new Usuario();
        usuario.setUsuario_id(1);
        usuario.setNombre("Carlos");
        usuario.setNombre_completo("Carlos");

        when(usuarioRepository.findAll()).thenReturn(List.of(usuario));

        List<GetUserNameSo> result = usuarioService.getUserByName();
        assertEquals(1, result.size());
        assertEquals("Carlos", result.get(0).nombre_completo());
    }

    @Test
    void getUserByName_empty() {
        when(usuarioRepository.findAll()).thenReturn(List.of());
        List<GetUserNameSo> result = usuarioService.getUserByName();
        assertTrue(result.isEmpty());
    }

    @Test
    void updateUsuario_success() {
        Usuario usuario = new Usuario();
        usuario.setUsuario_id(1);

        GetUserDto dto = GetUserDto.builder()
                .iduser("1")
                .correo("correo@correo.com")
                .contrasena("1234")
                .nombre("nombre")
                .apellidos("apellidos")
                .nombre_completo("nombre completo")
                .ano_nacimiento("1990")
                .prefijo("34")
                .telefono("123456789")
                .direccion("direccion")
                .apodo("apodo")
                .foto("foto")
                .genero("M")
                .fecha_creacion(new java.util.Date())
                .ultimo_acceso(new java.util.Date())
                .discord("discord")
                .ident_fiscal("fiscal")
                .verificado(true)
                .fecha_examen("2024-06-01")
                .aciertos_examen("10")
                .nota_examen("5.0")
                .ips(false)
                .baremo("5.0")
                .build();

        when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario));
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario result = usuarioService.updateUsuario(dto, 1);
        assertEquals("nombre", result.getNombre());
        assertEquals("correo@correo.com", result.getCorreo());
        assertEquals("apellidos", result.getApellidos());
        assertEquals("nombre completo", result.getNombre_completo());
        assertEquals("1990", String.valueOf(result.getAno_nacimiento()));
        assertEquals("34", result.getPrefijo());
        assertEquals(Integer.valueOf("123456789"), result.getTelefono());
        assertEquals("direccion", result.getDireccion());
        assertEquals("apodo", result.getApodo());
        assertEquals("foto", result.getFoto());
        assertEquals("M", result.getGenero());
        assertEquals("discord", result.getDiscord());
        assertEquals("fiscal", result.getIdent_fiscal());
        assertTrue(result.getVerificado());
        assertEquals("10", String.valueOf(result.getAciertos_examen()));
        assertEquals(5.0, Double.parseDouble(result.getBaremo()));    }

    @Test
    void updateUsuario_notFound() {
        GetUserDto dto = mock(GetUserDto.class);
        when(usuarioRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> usuarioService.updateUsuario(dto, 1));
    }
}