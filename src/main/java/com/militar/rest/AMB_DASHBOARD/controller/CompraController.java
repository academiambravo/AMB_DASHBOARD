package com.militar.rest.AMB_DASHBOARD.controller;


import com.militar.rest.AMB_DASHBOARD.dto.purchase.GetPurchaseDto;
import com.militar.rest.AMB_DASHBOARD.dto.purchase.GetPurchaseList;
import com.militar.rest.AMB_DASHBOARD.model.Compra;
import com.militar.rest.AMB_DASHBOARD.service.CompraService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/purchase")
public class CompraController {

    private final CompraService compraService;


    @Operation(
            summary = "Get all Purchases",
            description = "Retrieve a list of all purchass available in the system.",
            tags = {"Puchase"}
    )
    @GetMapping("/{id}")
    public ResponseEntity<GetPurchaseDto> getCourseById(@PathVariable  Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(compraService.getPurchaseById(id));
    }

    @Operation(
            summary = "Get all Purchases",
            description = "Retrieve a list of all purchass available in the system.",
            tags = {"Puchase"}
    )
    @GetMapping("/list")
    public ResponseEntity<GetPurchaseList> getPurchaseList() {
        return ResponseEntity.status(HttpStatus.OK).body(compraService.getPurchaseList());
    }


    @Operation(
            summary = "Create a new Purchase",
            description = "Create a new purchase with the provided details.",
            tags = {"Purchase"}
    )
    @PostMapping()
    public ResponseEntity<?> createPurchase(@RequestBody Compra purchase) {
        return ResponseEntity.status(HttpStatus.CREATED).body(compraService.createPurchase(purchase));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePurchase(@PathVariable Integer id, @RequestBody GetPurchaseDto purchase) {
        return ResponseEntity.status(HttpStatus.OK).body(compraService.updatePurchase(id, purchase));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<GetPurchaseDto> getPurchaseByUserId(@PathVariable Integer userId) {
        return ResponseEntity.status(HttpStatus.OK).body(compraService.getPurchaseByUserId(userId));
    }


}
