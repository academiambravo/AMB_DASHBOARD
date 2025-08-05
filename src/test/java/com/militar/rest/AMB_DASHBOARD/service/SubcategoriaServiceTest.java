package com.militar.rest.AMB_DASHBOARD.service;

import com.militar.rest.AMB_DASHBOARD.dto.subcategory.CreateSubcategoryDto;
import com.militar.rest.AMB_DASHBOARD.dto.subcategory.GetSubCategoryDto;
import com.militar.rest.AMB_DASHBOARD.dto.subcategory.GetSubcategoryListDto;
import com.militar.rest.AMB_DASHBOARD.dto.subcategory.UpdateSubcategoryDto;
import com.militar.rest.AMB_DASHBOARD.model.Subcategoria;
import com.militar.rest.AMB_DASHBOARD.repository.SubcategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SubcategoriaServiceTest {

    private SubcategoriaRepository subcategoriaRepository;
    private SubcategoriaService subcategoriaService;

    @BeforeEach
    void setUp() {
        subcategoriaRepository = mock(SubcategoriaRepository.class);
        subcategoriaService = new SubcategoriaService(subcategoriaRepository);
    }

    @Test
    void getSubcategoryList_success() {
        List<Subcategoria> subcategorias = List.of(mock(Subcategoria.class));
        when(subcategoriaRepository.findAll()).thenReturn(subcategorias);
        GetSubcategoryListDto listDto = mock(GetSubcategoryListDto.class);
        try (MockedStatic<GetSubcategoryListDto> mocked = mockStatic(GetSubcategoryListDto.class)) {
            mocked.when(() -> GetSubcategoryListDto.getSubcategories(subcategorias)).thenReturn(listDto);
            assertEquals(listDto, subcategoriaService.getSubcategoryList());
        }
    }

    @Test
    void getSubcategoryList_empty() {
        when(subcategoriaRepository.findAll()).thenReturn(List.of());
        assertThrows(EntityNotFoundException.class, () -> subcategoriaService.getSubcategoryList());
    }

    @Test
    void findById_success() {
        Subcategoria subcategoria = mock(Subcategoria.class);
        when(subcategoriaRepository.findById(1)).thenReturn(Optional.of(subcategoria));
        GetSubCategoryDto dto = mock(GetSubCategoryDto.class);
        try (MockedStatic<GetSubCategoryDto> mocked = mockStatic(GetSubCategoryDto.class)) {
            mocked.when(() -> GetSubCategoryDto.from(subcategoria)).thenReturn(dto);
            assertEquals(dto, subcategoriaService.findById(1));
        }
    }

    @Test
    void findById_notFound() {
        when(subcategoriaRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> subcategoriaService.findById(1));
    }

    @Test
    void findByName_success() {
        Subcategoria subcategoria = mock(Subcategoria.class);
        when(subcategoriaRepository.findByNombre("test")).thenReturn(Optional.of(subcategoria));
        GetSubCategoryDto dto = mock(GetSubCategoryDto.class);
        try (MockedStatic<GetSubCategoryDto> mocked = mockStatic(GetSubCategoryDto.class)) {
            mocked.when(() -> GetSubCategoryDto.from(subcategoria)).thenReturn(dto);
            assertEquals(dto, subcategoriaService.findByName("test"));
        }
    }

    @Test
    void findByName_notFound() {
        when(subcategoriaRepository.findByNombre("test")).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> subcategoriaService.findByName("test"));
    }

    @Test
    void create_success() {
        CreateSubcategoryDto dto = mock(CreateSubcategoryDto.class);
        when(dto.name()).thenReturn("nombre");
        when(dto.active()).thenReturn(true);
        Subcategoria subcategoria = mock(Subcategoria.class);
        when(subcategoriaRepository.save(any(Subcategoria.class))).thenReturn(subcategoria);

        assertEquals(subcategoria, subcategoriaService.create(dto));
        verify(subcategoriaRepository).save(any(Subcategoria.class));
    }

    @Test
    void update_success() {
        UpdateSubcategoryDto dto = mock(UpdateSubcategoryDto.class);
        Subcategoria subcategoria = mock(Subcategoria.class);
        when(subcategoriaRepository.findById(1)).thenReturn(Optional.of(subcategoria));
        when(subcategoriaRepository.save(subcategoria)).thenReturn(subcategoria);

        assertEquals(subcategoria, subcategoriaService.update(1, dto));
        verify(subcategoriaRepository).save(subcategoria);
    }

    @Test
    void update_notFound() {
        UpdateSubcategoryDto dto = mock(UpdateSubcategoryDto.class);
        when(subcategoriaRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> subcategoriaService.update(1, dto));
    }

    @Test
    void delete_success() {
        when(subcategoriaRepository.existsById(1)).thenReturn(true);
        doNothing().when(subcategoriaRepository).deleteById(1);
        assertDoesNotThrow(() -> subcategoriaService.delete(1));
        verify(subcategoriaRepository).deleteById(1);
    }

    @Test
    void delete_notFound() {
        when(subcategoriaRepository.existsById(1)).thenReturn(false);
        assertThrows(EntityNotFoundException.class, () -> subcategoriaService.delete(1));
    }
}