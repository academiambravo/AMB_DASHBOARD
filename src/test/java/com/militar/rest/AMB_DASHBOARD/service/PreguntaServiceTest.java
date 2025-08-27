package com.militar.rest.AMB_DASHBOARD.service;

import com.militar.rest.AMB_DASHBOARD.model.Pregunta;
import com.militar.rest.AMB_DASHBOARD.repository.PreguntaRepository;
import com.militar.rest.AMB_DASHBOARD.service.PreguntaService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PreguntaServiceTest {

    private PreguntaRepository preguntaRepository;
    private PreguntaService preguntaService;

    @BeforeEach
    void setUp() {
        preguntaRepository = mock(PreguntaRepository.class);
        preguntaService = new PreguntaService(preguntaRepository);
    }

    @Test
    void getAnswersByCategoryId_success() {
        Pregunta pregunta = new Pregunta();
        when(preguntaRepository.findPreguntasBySubcategoria_IdSubcategoria(1)).thenReturn(List.of(pregunta));
        List<Pregunta> result = preguntaService.getAnswersByCategoryId(1);
        assertEquals(1, result.size());
    }

    @Test
    void getAnswersByCategoryId_empty() {
        when(preguntaRepository.findPreguntasBySubcategoria_IdSubcategoria(1)).thenReturn(List.of());
        List<Pregunta> result = preguntaService.getAnswersByCategoryId(1);
        assertTrue(result.isEmpty());
    }

    @Test
    void getPreguntaById_success() {
        Pregunta pregunta = new Pregunta();
        when(preguntaRepository.findById(1)).thenReturn(Optional.of(pregunta));
        Pregunta result = preguntaService.getPreguntaById(1);
        assertNotNull(result);
    }

    @Test
    void getPreguntaById_notFound() {
        when(preguntaRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> preguntaService.getPreguntaById(1));
    }

    @Test
    void createPregunta_success() {
        Pregunta pregunta = new Pregunta();
        when(preguntaRepository.save(pregunta)).thenReturn(pregunta);
        Pregunta result = preguntaService.createPregunta(pregunta);
        assertNotNull(result);
    }

    @Test
    void updatePregunta_success() {
        Pregunta original = new Pregunta();
        Pregunta details = new Pregunta();
        details.setIdentificador("id");
        details.setOrden(2);
        details.setEnunciado("enunciado");
        details.setPregunta("pregunta");
        details.setRcorrecta("rc");
        details.setRfalsa1("rf1");
        details.setRfalsa2("rf2");
        details.setRfalsa3("rf3");
        details.setFoto("foto");
        details.setFoto_pregunta("foto_p");
        details.setDescripcion_respuesta("desc");
        details.setFoto_respuesta("foto_r");
        details.setUsuario_modificacion("user");

        when(preguntaRepository.findById(1)).thenReturn(Optional.of(original));
        when(preguntaRepository.save(original)).thenReturn(original);

        Pregunta result = preguntaService.updatePregunta(1, details);
        assertEquals("id", result.getIdentificador());
        assertEquals("user", result.getUsuario_modificacion());
    }

    @Test
    void updatePregunta_notFound() {
        Pregunta details = new Pregunta();
        when(preguntaRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> preguntaService.updatePregunta(1, details));
    }
}