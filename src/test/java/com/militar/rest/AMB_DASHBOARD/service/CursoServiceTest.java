package com.militar.rest.AMB_DASHBOARD.service;

import com.militar.rest.AMB_DASHBOARD.dto.course.GetCourseDto;
import com.militar.rest.AMB_DASHBOARD.dto.course.GetCourseListDto;
import com.militar.rest.AMB_DASHBOARD.model.Curso;
import com.militar.rest.AMB_DASHBOARD.repository.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CursoServiceTest {

    private CursoRepository cursoRepository;
    private CursoService cursoService;

    @BeforeEach
    void setUp() {
        cursoRepository = mock(CursoRepository.class);
        cursoService = new CursoService(cursoRepository);
    }

    @Test
    void getCourseList_returnsList() {
        Curso curso = Curso.builder().curso_id(1).nombreCurso("Test").build();
        when(cursoRepository.findAll()).thenReturn(Arrays.asList(curso));
        GetCourseListDto result = cursoService.getCourseList();
        assertNotNull(result);
    }

    @Test
    void getCourseList_throwsExceptionIfEmpty() {
        when(cursoRepository.findAll()).thenReturn(Arrays.asList());
        assertThrows(EntityNotFoundException.class, () -> cursoService.getCourseList());
    }

    @Test
    void getCourseById_returnsDto() {
        Curso curso = Curso.builder().curso_id(1).nombreCurso("Test").build();
        when(cursoRepository.findById(1)).thenReturn(Optional.of(curso));
        GetCourseDto result = cursoService.getCourseById(1);
        assertNotNull(result);
        assertEquals("Test", result.course_name());
    }

    @Test
    void getCourseById_throwsException() {
        when(cursoRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> cursoService.getCourseById(1));
    }

    @Test
    void getCourseByName_returnsDto() {
        Curso curso = Curso.builder().curso_id(1).nombreCurso("Test").build();
        when(cursoRepository.findByNombreCurso("Test")).thenReturn(Optional.of(curso));
        GetCourseDto result = cursoService.getCourseByName("Test");
        assertNotNull(result);
        assertEquals("Test", result.course_name());
    }

    @Test
    void getCourseByName_throwsException() {
        when(cursoRepository.findByNombreCurso("Test")).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> cursoService.getCourseByName("Test"));
    }

    @Test
    void deleteCourse_callsRepository() {
        doNothing().when(cursoRepository).deleteById(1);
        cursoService.deleteCourse(1);
        verify(cursoRepository, times(1)).deleteById(1);
    }

    @Test
    void updateCourse_updatesAndSaves() {
        Curso curso = Curso.builder().curso_id(1).build();
        when(cursoRepository.findById(1)).thenReturn(Optional.of(curso));
        when(cursoRepository.save(any(Curso.class))).thenReturn(curso);

        GetCourseDto dto = GetCourseDto.builder()
                .course_id("1")
                .course_name("Nuevo")
                .course_price("100.0")
                .course_description("desc")
                .course_days("10")
                .created_at(LocalDateTime.now().toString())
                .created_by("admin")
                .course_start(LocalDateTime.now().toString())
                .course_end(LocalDateTime.now().plusDays(10).toString())
                .enabled(true)
                .mode("online")
                .build();

        Curso result = cursoService.updateCourse(1, dto);
        assertNotNull(result);
        verify(cursoRepository).save(any(Curso.class));
    }

    @Test
    void createCourse_createsAndSaves() {
        Curso curso = Curso.builder().curso_id(1).build();
        when(cursoRepository.save(any(Curso.class))).thenReturn(curso);

        GetCourseDto dto = GetCourseDto.builder()
                .course_id("1")
                .course_name("Nuevo")
                .course_price("100.0")
                .course_description("desc")
                .course_days("10")
                .created_at(LocalDateTime.now().toString())
                .created_by("admin")
                .course_start(LocalDateTime.now().toString())
                .course_end(LocalDateTime.now().plusDays(10).toString())
                .enabled(true)
                .mode("online")
                .build();

        Curso result = cursoService.createCourse(dto);
        assertNotNull(result);
        verify(cursoRepository).save(any(Curso.class));
    }
}