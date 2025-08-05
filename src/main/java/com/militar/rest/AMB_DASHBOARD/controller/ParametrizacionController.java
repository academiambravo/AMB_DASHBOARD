package com.militar.rest.AMB_DASHBOARD.controller;

import com.militar.rest.AMB_DASHBOARD.dto.parametrizacion.CreateParametrizationDto;
import com.militar.rest.AMB_DASHBOARD.model.Parametrizacion;
import com.militar.rest.AMB_DASHBOARD.service.ParametrizacionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/parameterization")
public class ParametrizacionController {

    private final ParametrizacionService parametrizacionService;


    @Operation(
            summary = "Get all parameterizations",
            description = "Retrieve a list of all parameterizations available in the system.",
            tags = {"Parameterization"}

    )
    @GetMapping("/list")
    public ResponseEntity<List<Parametrizacion>> getParametrizationList() {
        return ResponseEntity.status(HttpStatus.OK).body(parametrizacionService.getParametrizationList());
    }

    @Operation(
            summary = "Get parameterization by ID",
            description = "Retrieve a specific parameterization by its ID.",
            tags = {"Parameterization"}
    )
    @GetMapping("/{id}")
    public ResponseEntity<Parametrizacion> findById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(parametrizacionService.getParametrizationById(id));
    }

    @Operation(
            summary = "Delete parameterization by name",
            description = "Delete a specific parameterization by id",
            tags = {"Parameterization"}
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        parametrizacionService.deleteParametrization(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(
            summary = "Create a new parameterization",
            description = "Create a new parameterization with the provided details.",
            tags = {"Parameterization"}
    )
    @PostMapping()
    public ResponseEntity<Parametrizacion> createNewParametrization(@RequestBody Parametrizacion newParametrization) {
        return ResponseEntity.status(HttpStatus.OK).body(parametrizacionService.createParametrization(newParametrization));
    }

    @Operation(
            summary = "Update an existing parameterization",
            description = "Update the details of an existing parameterization by its ID.",
            tags = {"Parameterization"}
    )
    @PatchMapping("/{id}")
    public ResponseEntity<Parametrizacion> updateParametrization(
            @PathVariable Integer id,
            @RequestBody Parametrizacion updatedParametrization
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(parametrizacionService.updateParametrization(id, updatedParametrization));
    }

}
