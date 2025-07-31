package com.militar.rest.AMB_DASHBOARD;// src/test/java/com/militar/rest/AMB_DASHBOARD/service/CursoServiceTest.java

import com.militar.rest.AMB_DASHBOARD.dto.course.GetCourseDto;
import com.militar.rest.AMB_DASHBOARD.dto.course.GetCourseListDto;
import com.militar.rest.AMB_DASHBOARD.model.Curso;
import com.militar.rest.AMB_DASHBOARD.repository.CursoRepository;
import com.militar.rest.AMB_DASHBOARD.service.CursoService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class CursoServiceTest {

    @Mock
    private CursoRepository repo;

    @InjectMocks
    private CursoService service;

    private Curso sampleCurso;
    private GetCourseDto sampleDto;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        sampleCurso = Curso.builder()
                .curso_id(10)
                .nombreCurso("Estrategia Militar")
                .precio(200.0)
                .descripcion("Curso avanzado")
                .dias(15)
                .fecha_creacion("2024-06-01T10:00:00")
                .usuario_creacion("carlos")
                .fecha_inicio(LocalDateTime.parse("2024-06-01T10:00:00"))
                .fecha_fin(LocalDateTime.parse("2024-07-10T18:00:00"))
                .habilitado(true)
                .modo("presencial")
                .build();

        sampleDto = GetCourseDto.from(sampleCurso);
    }

    @Test
    @DisplayName("Debe devolver lista de cursos si existen")
    void listarCursos_existentes() {
        when(repo.findAll()).thenReturn(List.of(sampleCurso));
        GetCourseListDto lista = service.getCourseList();
        assertThat(lista.courses()).hasSize(1);
        assertThat(lista.courses().get(0).course_name()).isEqualTo("Estrategia Militar");
    }

    @Test
    @DisplayName("Debe lanzar excepción si no hay cursos")
    void listarCursos_vacio() {
        when(repo.findAll()).thenReturn(Collections.emptyList());
        assertThatThrownBy(() -> service.getCourseList())
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessageContaining("No courses found");
    }

    @Test
    void buscarPorId_existente() {
        when(repo.findById(10)).thenReturn(Optional.of(sampleCurso));
        GetCourseDto dto = service.getCourseById(10);
        assertThat(dto.course_name()).isEqualTo("Estrategia Militar");
    }

    @Test
    void buscarPorId_inexistente() {
        when(repo.findById(99)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> service.getCourseById(99))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessageContaining("Course not found with id");
    }

    @Test
    void buscarPorNombre_existente() {
        when(repo.findByNombreCurso("Estrategia Militar")).thenReturn(Optional.of(sampleCurso));
        GetCourseDto dto = service.getCourseByName("Estrategia Militar");
        assertThat(dto.course_description()).contains("avanzado");
    }

    @Test
    void buscarPorNombre_inexistente() {
        when(repo.findByNombreCurso("No existe")).thenReturn(Optional.empty());
        assertThatThrownBy(() -> service.getCourseByName("No existe"))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void eliminarCurso() {
        doNothing().when(repo).deleteById(10);
        service.deleteCourse(10);
        verify(repo).deleteById(10);
    }

    @Test
    void actualizarCurso_existente() {
        when(repo.findById(10)).thenReturn(Optional.of(sampleCurso));
        when(repo.save(any(Curso.class))).thenAnswer(inv -> inv.getArgument(0));
        Curso actualizado = service.updateCourse(10, sampleDto);
        assertThat(actualizado.getNombreCurso()).isEqualTo(sampleDto.course_name());
        assertThat(actualizado.getPrecio()).isEqualTo(Double.parseDouble(sampleDto.course_price()));
    }

    @Test
    void actualizarCurso_inexistente() {
        when(repo.findById(10)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> service.updateCourse(10, sampleDto))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void crearCurso() {
        when(repo.save(any(Curso.class))).thenReturn(sampleCurso);
        Curso nuevo = service.createCourse(sampleDto);
        assertThat(nuevo.getDescripcion()).isEqualTo("Curso avanzado");
        assertThat(nuevo.getModo()).isEqualTo("presencial");
    }
}