package com.militar.rest.AMB_DASHBOARD.controller;

import com.militar.rest.AMB_DASHBOARD.model.Pregunta;
import com.militar.rest.AMB_DASHBOARD.service.PreguntaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/question")
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PreguntaController {

    private final PreguntaService preguntaService;

    @GetMapping("/{id}")
    public ResponseEntity<Pregunta> getPreguntaById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(preguntaService.getPreguntaById(id));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Pregunta>> getAnswersByCategoryId(@PathVariable Integer categoryId){
        return ResponseEntity.status(HttpStatus.OK).body(preguntaService.getAnswersByCategoryId(categoryId));
    }

    @PostMapping()
    public ResponseEntity<Pregunta> createPregunta(@RequestBody Pregunta pregunta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(preguntaService.createPregunta(pregunta));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pregunta> updatePregunta(@PathVariable Integer id, @RequestBody Pregunta preguntaDetails) {
        return ResponseEntity.status(HttpStatus.OK).body(preguntaService.updatePregunta(id, preguntaDetails));
    }
}
