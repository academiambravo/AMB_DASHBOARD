package com.militar.rest.AMB_DASHBOARD.controller;


import com.militar.rest.AMB_DASHBOARD.dto.subcategory.CreateSubcategoryDto;
import com.militar.rest.AMB_DASHBOARD.dto.subcategory.GetSubCategoryDto;
import com.militar.rest.AMB_DASHBOARD.dto.subcategory.GetSubcategoryListDto;
import com.militar.rest.AMB_DASHBOARD.dto.subcategory.UpdateSubcategoryDto;
import com.militar.rest.AMB_DASHBOARD.model.Subcategoria;
import com.militar.rest.AMB_DASHBOARD.service.SubcategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/subCategory")
public class SubcategoriaController {

    private final SubcategoriaService subcategoriaService;


    @Operation(
            summary = "Get all scategories",
            description = "Returns a list of all subcategories in the system.",
            tags = {"Subcategory"}
    )
    @GetMapping("/list")
    public ResponseEntity<GetSubcategoryListDto> getSubcategoryList() {
        return ResponseEntity.ok(subcategoriaService.getSubcategoryList());
    }

    @Operation(
            summary = "Get subcategory by ID",
            description = "Returns a specific subcategory by its ID.",
            tags = {"Subcategory"}
    )
    @GetMapping("/{id}")
    public ResponseEntity<GetSubCategoryDto> getSubcategoryById(@PathVariable Integer id) {
        return ResponseEntity.ok(subcategoriaService.findById(id));
    }

    @Operation(
            summary = "Get subcategory by name",
            description = "Returns a specific subcategory by its name.",
            tags = {"Subcategory"}
    )
    @GetMapping("/name")
    public ResponseEntity<GetSubCategoryDto> getSubcategoryByName(@RequestParam("subcategoryName") String name) {
        return ResponseEntity.ok(subcategoriaService.findByName(name));
    }

    @Operation(
            summary = "Create a new subcategory",
            description = "Creates a new subcategory in the system.",
            tags = {"Subcategory"}
    )
    @PostMapping()
    public ResponseEntity<Subcategoria> createSubcategory(@RequestBody CreateSubcategoryDto newSubcategory) {
        return ResponseEntity.ok(subcategoriaService.create(newSubcategory));
    }

    @Operation(
            summary = "Update an existing subcategory",
            description = "Updates an existing subcategory in the system.",
            tags = {"Subcategory"}
    )
    @PatchMapping("/{id}")
    public ResponseEntity<Subcategoria> updateSubcategory(@PathVariable Integer id, @RequestBody UpdateSubcategoryDto subcategory) {
        return ResponseEntity.ok(subcategoriaService.update(id,subcategory));
    }

    @Operation(
            summary = "Delete a subcategory",
            description = "Deletes a specific subcategory by its ID.",
            tags = {"Subcategory"}
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubcategory(@PathVariable Integer id) {
        subcategoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}