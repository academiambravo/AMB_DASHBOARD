package com.militar.rest.AMB_DASHBOARD.service;

import com.militar.rest.AMB_DASHBOARD.model.Afiliado;
import com.militar.rest.AMB_DASHBOARD.repository.AfiliadoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class AfiliadoService {

    private final AfiliadoRepository afiliadoRepository;

    public List<Afiliado> getAffiliateList() {

        if (afiliadoRepository.findAll().isEmpty())
            throw new EntityNotFoundException("No affiliates found");

        return afiliadoRepository.findAll();
    }

    public Afiliado getAffiliateById(Integer id) {
        return afiliadoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Affiliate not found with id: " + id));
    }

    public Afiliado createAffiliate(Afiliado afiliado) {
        return afiliadoRepository.save(afiliado);
    }

    public Afiliado updateAffiliate(Integer id, Afiliado afiliado) {
        Afiliado existingAffiliate = getAffiliateById(id);
        existingAffiliate.setUsuario(afiliado.getUsuario());
        existingAffiliate.setContrasena(afiliado.getContrasena());
        existingAffiliate.setCodigo(afiliado.getCodigo());
        existingAffiliate.setDesc_afil_arcade(afiliado.getDesc_afil_arcade());
        existingAffiliate.setDesc_alum_arcade(afiliado.getDesc_alum_arcade());
        existingAffiliate.setDesc_afil_campana(afiliado.getDesc_afil_campana());
        existingAffiliate.setDesc_alum_campana(afiliado.getDesc_alum_campana());
        existingAffiliate.setFecha_fin(afiliado.getFecha_fin());
        existingAffiliate.setUsos(afiliado.getUsos());
        existingAffiliate.setFecha_creacion(afiliado.getFecha_creacion());

        return afiliadoRepository.save(existingAffiliate);
    }

    public void deleteAffiliate(Integer id) {
        Afiliado existingAffiliate = getAffiliateById(id);
       existingAffiliate.setFecha_fin(Timestamp.valueOf(LocalDateTime.now()));
        afiliadoRepository.save(existingAffiliate);

    }
}
