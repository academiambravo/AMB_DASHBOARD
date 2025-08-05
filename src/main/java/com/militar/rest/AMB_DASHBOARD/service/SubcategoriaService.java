package com.militar.rest.AMB_DASHBOARD.service;

import com.militar.rest.AMB_DASHBOARD.dto.subcategory.CreateSubcategoryDto;
import com.militar.rest.AMB_DASHBOARD.dto.subcategory.GetSubCategoryDto;
import com.militar.rest.AMB_DASHBOARD.dto.subcategory.GetSubcategoryListDto;
import com.militar.rest.AMB_DASHBOARD.dto.subcategory.UpdateSubcategoryDto;
import com.militar.rest.AMB_DASHBOARD.model.Subcategoria;
import com.militar.rest.AMB_DASHBOARD.repository.SubcategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class SubcategoriaService {

    private final SubcategoriaRepository subcategoriaRepository;

    public GetSubcategoryListDto getSubcategoryList() {

        if(subcategoriaRepository.findAll().isEmpty())

            throw new EntityNotFoundException("No categories found");

        return GetSubcategoryListDto.getSubcategories(subcategoriaRepository.findAll());
    }

    public GetSubCategoryDto findById(Integer id) {

        return subcategoriaRepository.findById(id)
                .map(GetSubCategoryDto::from)
                .orElseThrow(() -> new EntityNotFoundException("Subcategory not found with id: " + id));
    }

    public GetSubCategoryDto findByName(String name) {

        return subcategoriaRepository.findByNombre(name)
                .map(GetSubCategoryDto::from)
                .orElseThrow(() -> new EntityNotFoundException("Subcategory not found with name: " + name));
    }

    public Subcategoria create (CreateSubcategoryDto newSubcategory) {

        Subcategoria subcategoria = Subcategoria.builder()
                .nombre(newSubcategory.name())
                .habilitada(newSubcategory.active())
                .fecha_creacion(LocalDateTime.now().toString())
                .habilitada(false)
                .build();

        return subcategoriaRepository.save(subcategoria);


    }

    public Subcategoria update (Integer id, UpdateSubcategoryDto subcategory) {

        Subcategoria existingSubcategory = subcategoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subcategory not found with id: " + id));

        existingSubcategory.setNombre(subcategory.name());
        existingSubcategory.setHabilitada(subcategory.active());
        existingSubcategory.setUsuario_modificacion(subcategory.updated_by());
        existingSubcategory.setFecha_modificacion(LocalDateTime.now().toString());
        existingSubcategory.setUsuario_creacion(subcategory.created_by());
        existingSubcategory.setFecha_creacion(subcategory.created_at());


        return subcategoriaRepository.save(existingSubcategory);
    }

    public void delete (Integer id) {

        if (!subcategoriaRepository.existsById(id)) {
            throw new EntityNotFoundException("Subcategory not found with id: " + id);
        }

        subcategoriaRepository.deleteById(id);
    }
}
