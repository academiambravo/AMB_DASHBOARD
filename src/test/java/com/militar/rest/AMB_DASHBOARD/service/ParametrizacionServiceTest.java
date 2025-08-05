package com.militar.rest.AMB_DASHBOARD.service;

import com.militar.rest.AMB_DASHBOARD.model.Parametrizacion;
import com.militar.rest.AMB_DASHBOARD.repository.ParametrizacionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ParametrizacionServiceTest {

    private ParametrizacionRepository parametrizacionRepository;
    private ParametrizacionService parametrizacionService;

    @BeforeEach
    void setUp() {
        parametrizacionRepository = mock(ParametrizacionRepository.class);
        parametrizacionService = new ParametrizacionService(parametrizacionRepository);
    }

    @Test
    void getParametrizationList_success() {
        Parametrizacion p = Parametrizacion.builder().clave("clave").valor(1).build();
        when(parametrizacionRepository.findAll()).thenReturn(List.of(p));
        List<Parametrizacion> result = parametrizacionService.getParametrizationList();
        assertEquals(1, result.size());
        assertEquals("clave", result.get(0).getClave());
    }

    @Test
    void getParametrizationList_empty() {
        when(parametrizacionRepository.findAll()).thenReturn(List.of());
        assertThrows(EntityNotFoundException.class, () -> parametrizacionService.getParametrizationList());
    }

    @Test
    void getParametrizationById_success() {
        Parametrizacion p = Parametrizacion.builder().clave("clave").valor(1).build();
        when(parametrizacionRepository.findById(1)).thenReturn(Optional.of(p));
        Parametrizacion result = parametrizacionService.getParametrizationById(1);
        assertEquals("clave", result.getClave());
    }

    @Test
    void getParametrizationById_notFound() {
        when(parametrizacionRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> parametrizacionService.getParametrizationById(1));
    }

    @Test
    void deleteParametrization_success() {
        doNothing().when(parametrizacionRepository).deleteById(1);
        assertDoesNotThrow(() -> parametrizacionService.deleteParametrization(1));
        verify(parametrizacionRepository, times(1)).deleteById(1);
    }

    @Test
    void createParametrization_success() {
        Parametrizacion input = Parametrizacion.builder().clave("c").valor(1).build();
        Parametrizacion saved = Parametrizacion.builder().clave("c").valor(1).build();
        when(parametrizacionRepository.save(any(Parametrizacion.class))).thenReturn(saved);
        Parametrizacion result = parametrizacionService.createParametrization(input);
        assertEquals("c", result.getClave());
        assertEquals(1, result.getValor());
        assertEquals(1, result.getValor());
    }

    @Test
    void updateParametrization_success() {
        Parametrizacion existing = Parametrizacion.builder().clave("old").valor(1).build();
        Parametrizacion update = Parametrizacion.builder().clave("new").valor(1).build();
        when(parametrizacionRepository.findById(1)).thenReturn(Optional.of(existing));
        when(parametrizacionRepository.save(existing)).thenReturn(existing);

        Parametrizacion result = parametrizacionService.updateParametrization(1, update);
        assertEquals("new", result.getClave());
        assertEquals(1, result.getValor());
    }
    @Test
    void updateParametrization_notFound() {
        Parametrizacion update = Parametrizacion.builder().clave("new").valor(1).build();
        when(parametrizacionRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> parametrizacionService.updateParametrization(1, update));
    }
}