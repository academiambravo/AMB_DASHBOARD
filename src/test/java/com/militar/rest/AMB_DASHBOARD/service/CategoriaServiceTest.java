package com.militar.rest.AMB_DASHBOARD.service;

import com.militar.rest.AMB_DASHBOARD.dto.category.CreateCategoryDto;
import com.militar.rest.AMB_DASHBOARD.dto.category.GetCategoriaDto;
import com.militar.rest.AMB_DASHBOARD.dto.category.GetCategoryListDto;
import com.militar.rest.AMB_DASHBOARD.dto.category.UpdateCategoryDto;
import com.militar.rest.AMB_DASHBOARD.model.Categoria;
import com.militar.rest.AMB_DASHBOARD.repository.CategoriaRepository;
import com.militar.rest.AMB_DASHBOARD.service.CategoriaService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoriaServiceTest {

    private CategoriaRepository categoriaRepository;
    private CategoriaService categoriaService;

    @BeforeEach
    void setUp() {
        categoriaRepository = mock(CategoriaRepository.class);
        categoriaService = new CategoriaService(categoriaRepository);
    }

    @Test
    void getCategoryList_success() {
        Categoria categoria = Categoria.builder().build();
        when(categoriaRepository.findAll()).thenReturn(List.of(categoria));
        when(categoriaRepository.findAll()).thenReturn(List.of(categoria));
        assertNotNull(categoriaService.getCategoryList());
    }

    @Test
    void getCategoryList_empty() {
        when(categoriaRepository.findAll()).thenReturn(List.of());
        assertThrows(EntityNotFoundException.class, () -> categoriaService.getCategoryList());
    }

    @Test
    void getCategoryById_success() {
        Categoria categoria = Categoria.builder().build();
        when(categoriaRepository.findById(1)).thenReturn(Optional.of(categoria));
        assertNotNull(categoriaService.getCategoryById(1));
    }

    @Test
    void getCategoryById_notFound() {
        when(categoriaRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> categoriaService.getCategoryById(1));
    }

    @Test
    void getCategoryByName_success() {
        Categoria categoria = Categoria.builder().build();
        when(categoriaRepository.findByNombre("test")).thenReturn(Optional.of(categoria));
        assertNotNull(categoriaService.getCategoryByName("test"));
    }

    @Test
    void getCategoryByName_notFound() {
        when(categoriaRepository.findByNombre("test")).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> categoriaService.getCategoryByName("test"));
    }

    @Test
    void createNewCategory_success() {
        CreateCategoryDto dto = mock(CreateCategoryDto.class);
        when(dto.name()).thenReturn("cat");
        when(dto.questionTime()).thenReturn(String.valueOf(10));
        when(dto.createdBy()).thenReturn("user");
        Categoria categoria = Categoria.builder().build();
        when(categoriaRepository.save(ArgumentMatchers.any(Categoria.class))).thenReturn(categoria);
        assertNotNull(categoriaService.createNewCategory(dto));
    }

    @Test
    void updateCategory_success() {
        Categoria categoria = Categoria.builder().build();
        UpdateCategoryDto dto = mock(UpdateCategoryDto.class);
        when(dto.category_name()).thenReturn("cat");
        when(dto.question_time()).thenReturn(String.valueOf(10));
        when(categoriaRepository.findById(1)).thenReturn(Optional.of(categoria));
        when(categoriaRepository.save(categoria)).thenReturn(categoria);
        assertNotNull(categoriaService.updateCategory(1, dto));
    }

    @Test
    void updateCategory_notFound() {
        UpdateCategoryDto dto = mock(UpdateCategoryDto.class);
        when(categoriaRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> categoriaService.updateCategory(1, dto));
    }

    @Test
    void deleteCategory_success() {
        doNothing().when(categoriaRepository).deleteById(1);
        assertDoesNotThrow(() -> categoriaService.deleteCategory(1));
    }
}