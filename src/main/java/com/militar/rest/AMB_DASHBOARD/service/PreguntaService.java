package com.militar.rest.AMB_DASHBOARD.service;

import com.militar.rest.AMB_DASHBOARD.model.Pregunta;
import com.militar.rest.AMB_DASHBOARD.repository.PreguntaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PreguntaService {

    private final PreguntaRepository preguntaRepository;

    public List<Pregunta> getAnswersByCategoryId(Integer categoryId) {

        return preguntaRepository.findPreguntasBySubcategoria_IdSubcategoria(categoryId);
    }


    public Pregunta getPreguntaById(Integer preguntaId) {
        return preguntaRepository.findById(preguntaId)
                .orElseThrow(() -> new EntityNotFoundException("Pregunta not found with id: " + preguntaId));
    }

    public Pregunta createPregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    public Pregunta updatePregunta(Integer preguntaId, Pregunta preguntaDetails) {
        Pregunta pregunta = getPreguntaById(preguntaId);
        pregunta.setIdentificador(preguntaDetails.getIdentificador());
        pregunta.setOrden(preguntaDetails.getOrden());
        pregunta.setEnunciado(preguntaDetails.getEnunciado());
        pregunta.setPregunta(preguntaDetails.getPregunta());
        pregunta.setRcorrecta(preguntaDetails.getRcorrecta());
        pregunta.setRfalsa1(preguntaDetails.getRfalsa1());
        pregunta.setRfalsa2(preguntaDetails.getRfalsa2());
        pregunta.setRfalsa3(preguntaDetails.getRfalsa3());
        pregunta.setFoto(preguntaDetails.getFoto());
        pregunta.setFoto_pregunta(preguntaDetails.getFoto_pregunta());
        pregunta.setDescripcion_respuesta(preguntaDetails.getDescripcion_respuesta());
        pregunta.setFoto_respuesta(preguntaDetails.getFoto_respuesta());
        pregunta.setUsuario_modificacion(preguntaDetails.getUsuario_modificacion());
        return preguntaRepository.save(pregunta);
    }


}
