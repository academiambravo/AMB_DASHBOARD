package com.militar.rest.AMB_DASHBOARD.service;

import com.militar.rest.AMB_DASHBOARD.dto.subcategory.CreateSubcategoryDto;
import com.militar.rest.AMB_DASHBOARD.dto.subcategory.GetSubCategoryDto;
import com.militar.rest.AMB_DASHBOARD.dto.subcategory.GetSubcategoryListDto;
import com.militar.rest.AMB_DASHBOARD.dto.subcategory.UpdateSubcategoryDto;
import com.militar.rest.AMB_DASHBOARD.model.Categoria;
import com.militar.rest.AMB_DASHBOARD.model.Subcategoria;
import com.militar.rest.AMB_DASHBOARD.repository.SubcategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        Categoria categoria = new Categoria();
        categoria.setCategoria_id(1);
        categoria.setNombre("Cat1");

        Subcategoria sub = new Subcategoria();
        sub.setIdSubcategoria(1);
        sub.setNombre("Sub1");
        sub.setCategoria(categoria); // Asigna la categoría

        List<Subcategoria> subs = List.of(sub);

        when(subcategoriaRepository.findAll()).thenReturn(subs);

        GetSubcategoryListDto listDto = subcategoriaService.getSubcategoryList();

        assertNotNull(listDto);
    }

    @Test
    void getSubcategoryList_empty() {
        when(subcategoriaRepository.findAll()).thenReturn(List.of());
        assertThrows(EntityNotFoundException.class, () -> subcategoriaService.getSubcategoryList());
    }

    @Test
    void findById_success() {
        Categoria categoria = new Categoria();
        categoria.setCategoria_id(1);
        categoria.setNombre("Cat1");

        Subcategoria sub = new Subcategoria();
        sub.setIdSubcategoria(1);
        sub.setNombre("Sub1");
        sub.setCategoria(categoria); // Asigna la categoría

        when(subcategoriaRepository.findById(1)).thenReturn(Optional.of(sub));

        GetSubCategoryDto dto = subcategoriaService.findById(1);

        assertNotNull(dto);
        assertEquals("Sub1", dto.subcategory_name());
    }

    @Test
    void findById_notFound() {
        when(subcategoriaRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> subcategoriaService.findById(1));
    }

    @Test
    void findByName_success() {
        // Crear la categoría
        Categoria categoria = new Categoria();
        categoria.setCategoria_id(1);
        categoria.setNombre("Cat1");

        // Crear la subcategoría y asignarle la categoría
        Subcategoria sub = new Subcategoria();
        sub.setIdSubcategoria(1);
        sub.setNombre("Sub1");
        sub.setCategoria(categoria);  // <- IMPORTANTE
        sub.setHabilitada(true);

        when(subcategoriaRepository.findByNombre("Sub1")).thenReturn(Optional.of(sub));

        GetSubCategoryDto dto = subcategoriaService.findByName("Sub1");

        assertNotNull(dto);
        assertEquals("Sub1", dto.subcategory_name());
        assertEquals("1", dto.category_id());    }


    @Test
    void findByName_notFound() {
        when(subcategoriaRepository.findByNombre("Sub1")).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> subcategoriaService.findByName("Sub1"));
    }

    @Test
    void create_success() {
        Categoria categoria = new Categoria();
        categoria.setCategoria_id(1);
        categoria.setNombre("Cat1");

        Subcategoria sub = new Subcategoria();
        sub.setNombre("Nueva");
        sub.setHabilitada(true);
        sub.setCategoria(categoria); // Asigna la categoría

        CreateSubcategoryDto dto = CreateSubcategoryDto.from(sub);

        when(subcategoriaRepository.save(any(Subcategoria.class))).thenReturn(sub);

        Subcategoria created = subcategoriaService.create(dto);

        assertNotNull(created);
        assertEquals("Nueva", created.getNombre());
        verify(subcategoriaRepository).save(any(Subcategoria.class));
    }


    @Test
    void update_success() {
        Categoria categoria = new Categoria();
        categoria.setCategoria_id(1);
        categoria.setNombre("Cat1");

        Subcategoria sub = new Subcategoria();
        sub.setIdSubcategoria(1);
        sub.setNombre("Original");
        sub.setHabilitada(true);
        sub.setUsuario_creacion("admin");
        sub.setUsuario_modificacion("admin2");
        sub.setFecha_creacion("2025-08-27");
        sub.setFecha_modificacion("2025-08-27");
        sub.setCategoria(categoria); // Asigna la categoría

        UpdateSubcategoryDto dto = UpdateSubcategoryDto.from(sub);

        when(subcategoriaRepository.findById(1)).thenReturn(Optional.of(sub));
        when(subcategoriaRepository.save(sub)).thenReturn(sub);

        Subcategoria updated = subcategoriaService.update(1, dto);

        assertEquals("Original", updated.getNombre());
        assertTrue(updated.isHabilitada());
        verify(subcategoriaRepository).save(sub);
    }


    @Test
    void update_notFound() {
        UpdateSubcategoryDto dto = new UpdateSubcategoryDto("Actualizada", "a", true,"c", "d", "e", "f");
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
