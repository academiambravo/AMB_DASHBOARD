package com.militar.rest.AMB_DASHBOARD.controller;

import com.militar.rest.AMB_DASHBOARD.dto.categoria.CreateCategoryDto;
import com.militar.rest.AMB_DASHBOARD.dto.categoria.GetCategoriaDto;
import com.militar.rest.AMB_DASHBOARD.dto.categoria.UpdateCategoryDto;
import com.militar.rest.AMB_DASHBOARD.model.Categoria;
import com.militar.rest.AMB_DASHBOARD.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Operation(
        summary = "Get all categories",
        description = "Returns a list of all categories in the system.",
        tags = {"Category"}
    )
    @GetMapping("/list")
    public ResponseEntity<?> getCategoryList() {
        return ResponseEntity.ok(categoriaService.getCategoryList());
    }

    @Operation(
        summary = "Get category by ID",
        description = "Returns a specific category by its ID.",
        tags = {"Category"}
    )
    @GetMapping("/{id}")
    public ResponseEntity<GetCategoriaDto> getCategoryById(@PathVariable Integer id) {
        return ResponseEntity.ok(categoriaService.getCategoryById(id));
    }

    @Operation(
        summary = "Get category by name",
        description = "Returns a specific category by its name.",
        tags = {"Category"}
    )
    @GetMapping("/name")
    public ResponseEntity<GetCategoriaDto> getCategoryByName(@RequestParam("categoryName") String name) {
        return ResponseEntity.ok(categoriaService.getCategoryByName(name));
    }

    @Operation(
        summary = "Create a new category",
        description = "Creates a new category with the provided details.",
        tags = {"Category"}
    )
    @PostMapping()
    public ResponseEntity<?> createNewCategory(@RequestBody CreateCategoryDto category) {
        return ResponseEntity.ok(categoriaService.createNewCategory(category));
    }

    @PatchMapping("/{id}")
    @Operation(
        summary = "Update an existing category",
        description = "Updates the details of an existing category by its ID.",
        tags = {"Category"}
    )
    public ResponseEntity<Categoria> updateCategory(
            @PathVariable Integer id,
            @RequestBody UpdateCategoryDto category
    ) {
        return ResponseEntity.ok(categoriaService.updateCategory(id, category));
    }

    @Operation(
        summary = "Delete a category",
        description = "Deletes a specific category by its ID.",
        tags = {"Category"}
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
        categoriaService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
