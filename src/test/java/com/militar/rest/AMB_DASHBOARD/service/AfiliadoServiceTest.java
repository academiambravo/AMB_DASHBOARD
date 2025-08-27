package com.militar.rest.AMB_DASHBOARD.service;

import com.militar.rest.AMB_DASHBOARD.model.Afiliado;
import com.militar.rest.AMB_DASHBOARD.repository.AfiliadoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AfiliadoServiceTest {

    private AfiliadoRepository afiliadoRepository;
    private AfiliadoService afiliadoService;

    @BeforeEach
    void setUp() {
        afiliadoRepository = mock(AfiliadoRepository.class);
        afiliadoService = new AfiliadoService(afiliadoRepository);
    }

    @Test
    void getAffiliateList_success() {
        Afiliado afiliado = new Afiliado();
        when(afiliadoRepository.findAll()).thenReturn(List.of(afiliado));
        List<Afiliado> result = afiliadoService.getAffiliateList();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void getAffiliateList_empty() {
        when(afiliadoRepository.findAll()).thenReturn(List.of());
        assertThrows(EntityNotFoundException.class, () -> afiliadoService.getAffiliateList());
    }

    @Test
    void getAffiliateById_success() {
        Afiliado afiliado = new Afiliado();
        when(afiliadoRepository.findById(1)).thenReturn(Optional.of(afiliado));
        Afiliado result = afiliadoService.getAffiliateById(1);
        assertNotNull(result);
    }

    @Test
    void getAffiliateById_notFound() {
        when(afiliadoRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> afiliadoService.getAffiliateById(1));
    }

    @Test
    void createAffiliate_success() {
        Afiliado afiliado = new Afiliado();
        when(afiliadoRepository.save(afiliado)).thenReturn(afiliado);
        Afiliado result = afiliadoService.createAffiliate(afiliado);
        assertNotNull(result);
        verify(afiliadoRepository).save(afiliado);
    }

    @Test
    void updateAffiliate_success() {
        Afiliado existing = new Afiliado();
        existing.setUsuario("old");
        Afiliado updated = new Afiliado();
        updated.setUsuario("new");
        when(afiliadoRepository.findById(1)).thenReturn(Optional.of(existing));
        when(afiliadoRepository.save(existing)).thenReturn(existing);

        Afiliado result = afiliadoService.updateAffiliate(1, updated);
        assertEquals("new", result.getUsuario());
        verify(afiliadoRepository).save(existing);
    }

    @Test
    void updateAffiliate_notFound() {
        Afiliado afiliado = new Afiliado();
        when(afiliadoRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> afiliadoService.updateAffiliate(1, afiliado));
    }

    @Test
    void deleteAffiliate_success() {
        Afiliado afiliado = new Afiliado();
        when(afiliadoRepository.findById(1)).thenReturn(Optional.of(afiliado));
        when(afiliadoRepository.save(afiliado)).thenReturn(afiliado);

        afiliadoService.deleteAffiliate(1);

        assertNotNull(afiliado.getFecha_fin());
        verify(afiliadoRepository).save(afiliado);
    }

    @Test
    void deleteAffiliate_notFound() {
        when(afiliadoRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> afiliadoService.deleteAffiliate(1));
    }
}