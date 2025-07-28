package com.militar.rest.AMB_DASHBOARD.service;

import com.militar.rest.AMB_DASHBOARD.dto.categoria.CreateCategoryDto;
import com.militar.rest.AMB_DASHBOARD.dto.categoria.GetCategoriaDto;
import com.militar.rest.AMB_DASHBOARD.dto.categoria.GetCategoryListDto;
import com.militar.rest.AMB_DASHBOARD.dto.categoria.UpdateCategoryDto;
import com.militar.rest.AMB_DASHBOARD.model.Categoria;
import com.militar.rest.AMB_DASHBOARD.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public GetCategoryListDto getCategoryList() {

        if(categoriaRepository.findAll().isEmpty())

            throw new EntityNotFoundException("No categories found");

        return GetCategoryListDto.getCategories(categoriaRepository.findAll());
    }

    public GetCategoriaDto getCategoryById(Integer id) {

        if(categoriaRepository.findById(id).isEmpty())
            throw new EntityNotFoundException("Category with id " + id + " not found");

        return GetCategoriaDto.from(categoriaRepository.findById(id).get());
    }

    public GetCategoriaDto getCategoryByName(String name) {

        if(categoriaRepository.findByNombre(name).isEmpty())
            throw new EntityNotFoundException("Category with name " + name + " not found");

        return GetCategoriaDto.from(categoriaRepository.findByNombre(name).get());
    }

    public Categoria createNewCategory (CreateCategoryDto category) {

        Categoria newCategory = Categoria.builder()
                .nombre(category.name())
                .tiempo_pregunta(category.questionTime())
                .usuario_creacion(category.createdBy())
                .fecha_creacion(LocalDateTime.now().toString())
                .build();

        return categoriaRepository.save(newCategory);

    }


    public Categoria updateCategory(Integer id , UpdateCategoryDto category) {

        Categoria existingCategory = categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category with id " + id + " not found"));

        existingCategory.setNombre(category.category_name());
        existingCategory.setTiempo_pregunta(category.question_time());
        existingCategory.setFecha_modificacion(LocalDateTime.now().toString());

        return categoriaRepository.save(existingCategory);
    }

    @Transactional
    public void deleteCategory(Integer id) {
        categoriaRepository.deleteById(id);
    }


}
