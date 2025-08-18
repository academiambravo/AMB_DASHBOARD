package com.militar.rest.AMB_DASHBOARD.controller;

import com.militar.rest.AMB_DASHBOARD.model.Afiliado;
import com.militar.rest.AMB_DASHBOARD.service.AfiliadoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/affiliate")
public class AfiliadoController {

    private final AfiliadoService afiliadoService;

    @Operation(
        summary = "Get all affiliates",
        description = "Retrieves a list of all affiliates in the system.",
        tags = {"Affiliate"}
    )
    @GetMapping("/list")
    public ResponseEntity<List<Afiliado>> getAffiliateList() {
        return ResponseEntity.status(HttpStatus.OK).body(afiliadoService.getAffiliateList());
    }

    @Operation(
        summary = "Get affiliate by ID",
        description = "Retrieves an affiliate by its ID.",
        tags = {"Affiliate"}
    )
    @GetMapping("/{id}")
    public ResponseEntity<Afiliado> getAffiliateById(@PathVariable  Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(afiliadoService.getAffiliateById(id));
    }

    @Operation(
        summary = "Delete an affiliate by ID",
        description = "Deletes an affiliate from the system by its ID.",
        tags = {"Affiliate"}
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAffiliate(@PathVariable Integer id) {
        afiliadoService.deleteAffiliate(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(
        summary = "Create a new affiliate",
        description = "Creates a new affiliate with the provided details.",
        tags = {"Affiliate"}
    )
    @PostMapping()
    public ResponseEntity<Afiliado> createAffiliate(@RequestBody Afiliado afiliado) {
        Afiliado createdAffiliate = afiliadoService.createAffiliate(afiliado);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAffiliate);
    }

    @Operation(
        summary = "Update an existing affiliate",
        description = "Updates the details of an existing affiliate by ID.",
        tags = {"Affiliate"}
    )
    @PatchMapping("/{id}")
    public ResponseEntity<Afiliado> updateAffiliate(@PathVariable Integer id, @RequestBody Afiliado afiliado) {
        Afiliado updatedAffiliate = afiliadoService.updateAffiliate(id, afiliado);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAffiliate);
    }

}


