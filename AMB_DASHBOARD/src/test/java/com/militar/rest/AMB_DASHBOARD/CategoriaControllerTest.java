package com.militar.rest.AMB_DASHBOARD;// src/test/java/com/militar/rest/AMB_DASHBOARD/controller/CategoriaControllerTest.java

import com.militar.rest.AMB_DASHBOARD.controller.CategoriaController;
import com.militar.rest.AMB_DASHBOARD.dto.category.CreateCategoryDto;
import com.militar.rest.AMB_DASHBOARD.dto.category.GetCategoriaDto;
import com.militar.rest.AMB_DASHBOARD.dto.category.GetCategoryListDto;
import com.militar.rest.AMB_DASHBOARD.dto.category.UpdateCategoryDto;
import com.militar.rest.AMB_DASHBOARD.model.Categoria;
import com.militar.rest.AMB_DASHBOARD.service.CategoriaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoriaControllerTest {

    @Mock
    private CategoriaService categoriaService;

    @InjectMocks
    private CategoriaController categoriaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCategoryList_returnsOk() {
        Object mockList = List.of();
        when(categoriaService.getCategoryList()).thenReturn((GetCategoryListDto) mockList);

        ResponseEntity<?> response = categoriaController.getCategoryList();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockList, response.getBody());
    }

    @Test
    void getCategoryById_returnsCategory() {
        GetCategoriaDto dto = mock(GetCategoriaDto.class);
        when(categoriaService.getCategoryById(1)).thenReturn(dto);

        ResponseEntity<GetCategoriaDto> response = categoriaController.getCategoryById(1);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(dto, response.getBody());
    }

    @Test
    void getCategoryByName_returnsCategory() {
        GetCategoriaDto dto = mock(GetCategoriaDto.class);
        when(categoriaService.getCategoryByName("Test")).thenReturn(dto);

        ResponseEntity<GetCategoriaDto> response = categoriaController.getCategoryByName("Test");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(dto, response.getBody());
    }

    @Test
    void createNewCategory_returnsCreatedCategory() {
        CreateCategoryDto dto = mock(CreateCategoryDto.class);
        Categoria categoria = mock(Categoria.class);
        when(categoriaService.createNewCategory(dto)).thenReturn(categoria);

        ResponseEntity<?> response = categoriaController.createNewCategory(dto);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(categoria, response.getBody());
    }

    @Test
    void updateCategory_returnsUpdatedCategory() {
        UpdateCategoryDto dto = mock(UpdateCategoryDto.class);
        Categoria categoria = mock(Categoria.class);
        when(categoriaService.updateCategory(1, dto)).thenReturn(categoria);

        ResponseEntity<Categoria> response = categoriaController.updateCategory(1, dto);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(categoria, response.getBody());
    }

    @Test
    void deleteCategory_returnsNoContent() {
        doNothing().when(categoriaService).deleteCategory(1);

        ResponseEntity<?> response = categoriaController.deleteCategory(1);

        assertEquals(204, response.getStatusCodeValue());
        assertNull(response.getBody());
    }
}