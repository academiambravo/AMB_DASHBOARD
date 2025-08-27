package com.militar.rest.AMB_DASHBOARD.service;

import com.militar.rest.AMB_DASHBOARD.dto.purchase.GetPurchaseDto;
import com.militar.rest.AMB_DASHBOARD.dto.purchase.GetPurchaseList;
import com.militar.rest.AMB_DASHBOARD.model.Compra;
import com.militar.rest.AMB_DASHBOARD.model.Curso;
import com.militar.rest.AMB_DASHBOARD.model.Usuario;
import com.militar.rest.AMB_DASHBOARD.repository.CompraRepository;
import com.militar.rest.AMB_DASHBOARD.repository.CursoRepository;
import com.militar.rest.AMB_DASHBOARD.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CompraServiceTest {

    private CompraRepository compraRepository;
    private CursoRepository cursoRepository;
    private UsuarioRepository usuarioRepository;
    private UsuarioService usuarioService;
    private CompraService compraService;

    @BeforeEach
    void setUp() {
        compraRepository = mock(CompraRepository.class);
        cursoRepository = mock(CursoRepository.class);
        usuarioRepository = mock(UsuarioRepository.class);
        usuarioService = mock(UsuarioService.class);
        compraService = new CompraService(compraRepository, cursoRepository, usuarioRepository, usuarioService);
    }

    @Test
    void getPurchaseById_success() {
        Compra compra = new Compra();
        when(compraRepository.findById(1)).thenReturn(Optional.of(compra));
        GetPurchaseDto dto = mock(GetPurchaseDto.class);
        mockStatic(GetPurchaseDto.class).when(() -> GetPurchaseDto.from(compra)).thenReturn(dto);

        GetPurchaseDto result = compraService.getPurchaseById(1);
        assertNotNull(result);
    }

    @Test
    void getPurchaseById_notFound() {
        when(compraRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> compraService.getPurchaseById(1));
    }

    @Test
    void getPurchaseByUserId_success() {
        Usuario usuario = new Usuario();
        usuario.setUsuario_id(1);
        Compra compra = new Compra();
        when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario));
        when(compraRepository.findAllByUsuario(usuario)).thenReturn(List.of(compra));
        GetPurchaseDto dto = mock(GetPurchaseDto.class);
        try (MockedStatic<GetPurchaseDto> mocked = mockStatic(GetPurchaseDto.class)) {
            mocked.when(() -> GetPurchaseDto.from(compra)).thenReturn(dto);
            GetPurchaseDto result = compraService.getPurchaseByUserId(1);
            assertNotNull(result);
        }
    }

    @Test
    void getPurchaseByUserId_empty() {
        Usuario usuario = new Usuario();
        usuario.setUsuario_id(1);
        when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario));
        when(compraRepository.findAllByUsuario(usuario)).thenReturn(List.of());
        assertThrows(EntityNotFoundException.class, () -> compraService.getPurchaseByUserId(1));
    }

    @Test
    void getPurchaseList_success() {
        Compra compra = new Compra();
        when(compraRepository.findAll()).thenReturn(List.of(compra));
        GetPurchaseList list = mock(GetPurchaseList.class);
        mockStatic(GetPurchaseList.class).when(() -> GetPurchaseList.from(anyList())).thenReturn(list);

        GetPurchaseList result = compraService.getPurchaseList();
        assertNotNull(result);
    }

    @Test
    void getPurchaseList_empty() {
        when(compraRepository.findAll()).thenReturn(List.of());
        assertThrows(EntityNotFoundException.class, () -> compraService.getPurchaseList());
    }

    @Test
    void createPurchase_success() {
        Curso curso = new Curso();
        curso.setCurso_id(1);
        Usuario usuario = new Usuario();
        usuario.setUsuario_id(2);

        Compra compra = new Compra();
        compra.setCursos(List.of(curso));
        compra.setUsuario(usuario);

        when(cursoRepository.findById(1)).thenReturn(Optional.of(curso));
        when(usuarioRepository.findById(2)).thenReturn(Optional.of(usuario));
        when(compraRepository.save(any(Compra.class))).thenReturn(compra);

        Compra result = compraService.createPurchase(compra);
        assertNotNull(result);
        verify(compraRepository).save(compra);
    }

    @Test
    void createPurchase_cursoNotFound() {
        Curso curso = new Curso();
        curso.setCurso_id(1);
        Usuario usuario = new Usuario();
        usuario.setUsuario_id(2);

        Compra compra = new Compra();
        compra.setCursos(List.of(curso));
        compra.setUsuario(usuario);

        when(cursoRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> compraService.createPurchase(compra));
    }

    @Test
    void createPurchase_usuarioNotFound() {
        Curso curso = new Curso();
        curso.setCurso_id(1);
        Usuario usuario = new Usuario();
        usuario.setUsuario_id(2);

        Compra compra = new Compra();
        compra.setCursos(List.of(curso));
        compra.setUsuario(usuario);

        when(cursoRepository.findById(1)).thenReturn(Optional.of(curso));
        when(usuarioRepository.findById(2)).thenReturn(Optional.empty());

        assertThrows(Exception.class, () -> compraService.createPurchase(compra));
    }

    @Test
    void updatePurchase_success() {
        Compra compra = new Compra();
        compra.setUsuario(new Usuario());
        compra.setCursos(List.of());

        GetPurchaseDto dto = mock(GetPurchaseDto.class);
        when(dto.purchase_price()).thenReturn("100.0");
        when(dto.purchase_date()).thenReturn("2024-01-01");
        when(dto.merchant_order()).thenReturn("order123");
        when(dto.discount_code()).thenReturn("desc10");
        when(dto.user_id()).thenReturn("2");
        when(dto.course_id()).thenReturn("3");

        Usuario usuario = new Usuario();
        usuario.setUsuario_id(2);
        Curso curso = new Curso();
        curso.setCurso_id(3);

        when(compraRepository.findById(1)).thenReturn(Optional.of(compra));
        when(usuarioRepository.findById(2)).thenReturn(Optional.of(usuario));
        when(cursoRepository.findById(3)).thenReturn(Optional.of(curso));
        when(compraRepository.save(any(Compra.class))).thenReturn(compra);

        Compra result = compraService.updatePurchase(1, dto);
        assertNotNull(result);
        verify(compraRepository).save(compra);
    }

    @Test
    void updatePurchase_notFound() {
        GetPurchaseDto dto = mock(GetPurchaseDto.class);
        when(compraRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> compraService.updatePurchase(1, dto));
    }

    @Test
    void updatePurchase_cursoNotFound() {
        Compra compra = new Compra();
        compra.setUsuario(new Usuario());
        compra.setCursos(List.of());

        GetPurchaseDto dto = mock(GetPurchaseDto.class);
        when(dto.course_id()).thenReturn("3");
        when(dto.purchase_price()).thenReturn(null);
        when(dto.purchase_date()).thenReturn(null);
        when(dto.merchant_order()).thenReturn(null);
        when(dto.discount_code()).thenReturn(null);
        when(dto.user_id()).thenReturn(null);

        when(compraRepository.findById(1)).thenReturn(Optional.of(compra));
        when(cursoRepository.findById(3)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> compraService.updatePurchase(1, dto));
    }
}