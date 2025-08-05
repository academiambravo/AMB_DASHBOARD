package com.militar.rest.AMB_DASHBOARD.service;

import com.militar.rest.AMB_DASHBOARD.dto.parametrizacion.CreateParametrizationDto;
import com.militar.rest.AMB_DASHBOARD.model.Parametrizacion;
import com.militar.rest.AMB_DASHBOARD.repository.ParametrizacionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ParametrizacionService {

    private final ParametrizacionRepository parametrizacionRepository;


    public List<Parametrizacion> getParametrizationList() {

        if(parametrizacionRepository.findAll().isEmpty())
            throw new EntityNotFoundException("No hay parametrizaciones disponibles");

        return parametrizacionRepository.findAll();
    }

    public Parametrizacion getParametrizationById(Integer id) {
        return parametrizacionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Parametrización no encontrada con ID: " + id));
    }

    @Transactional
    public void deleteParametrization(Integer id) {

        parametrizacionRepository.deleteById(id);
    }

    public Parametrizacion createParametrization(Parametrizacion parametrization) {

        Parametrizacion newParametrization = Parametrizacion.builder()
                .clave(parametrization.getClave())
                .valor(parametrization.getValor())
                .build();

        return parametrizacionRepository.save(newParametrization);
    }

    public Parametrizacion updateParametrization(Integer id, Parametrizacion parametrization) {

        Parametrizacion existingParametrization = getParametrizationById(id);

        existingParametrization.setClave(parametrization.getClave());
        existingParametrization.setValor(parametrization.getValor());

        return parametrizacionRepository.save(existingParametrization);
    }
}
