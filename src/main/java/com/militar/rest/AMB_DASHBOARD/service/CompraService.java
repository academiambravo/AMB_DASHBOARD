package com.militar.rest.AMB_DASHBOARD.service;

import com.militar.rest.AMB_DASHBOARD.dto.purchase.GetPurchaseDto;
import com.militar.rest.AMB_DASHBOARD.dto.purchase.GetPurchaseList;
import com.militar.rest.AMB_DASHBOARD.model.Compra;
import com.militar.rest.AMB_DASHBOARD.model.Curso;
import com.militar.rest.AMB_DASHBOARD.model.Usuario;
import com.militar.rest.AMB_DASHBOARD.repository.CompraRepository;
import com.militar.rest.AMB_DASHBOARD.repository.CursoRepository;
import com.militar.rest.AMB_DASHBOARD.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CompraService {

    private final CompraRepository compraRepository;
    private final CursoRepository cursoRepository;
    private final UsuarioRepository usuarioRepository;

    public GetPurchaseDto getPurchaseById(Integer userId) {
        return compraRepository.findById(userId)
                .map(GetPurchaseDto::from)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

    public GetPurchaseDto getPurchaseByUserId(Integer userId) {

        Usuario usuario = usuarioRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + userId));

        List<Compra> compras = compraRepository.findAllByUsuario(usuario);

        if (compras.isEmpty()) {
            throw new EntityNotFoundException("No purchases found for user with id: " + userId);
        }
        return GetPurchaseDto.from(compras.get(0));
    }

    @Transactional
    public GetPurchaseList getPurchaseList () {

        if(compraRepository.findAll().isEmpty())
            throw new EntityNotFoundException("No purchases found");

        return GetPurchaseList.from(compraRepository.findAll());

    }

    public Compra createPurchase(Compra newCompra) {
        List<Curso> cursos = newCompra.getCursos().stream()
                .map(c -> cursoRepository.findById(c.getCurso_id())
                        .orElseThrow(() -> new EntityNotFoundException("Curso no encontrado: " + c.getCurso_id())))
                .toList();
        newCompra.setCursos(cursos);

        Usuario usuario = usuarioRepository.findById(newCompra.getUsuario().getUsuario_id())
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + newCompra.getUsuario().getUsuario_id()));
        newCompra.setUsuario(usuario);

        return compraRepository.save(newCompra);
    }

    public Compra updatePurchase(Integer id, GetPurchaseDto purchaseDto) {

        Compra existingCompra = compraRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Purchase not found with id: " + id));

        // Actualizar precio compra
        if (purchaseDto.purchase_price() != null && !purchaseDto.purchase_price().isEmpty()) {
            existingCompra.setPrecio_compra(String.valueOf(Double.parseDouble(purchaseDto.purchase_price())));
        }

        // Actualizar fechas (parsear si no es null)
        if (purchaseDto.purchase_date() != null && !purchaseDto.purchase_date().isEmpty()) {
            existingCompra.setFecha_compra(String.valueOf(LocalDate.parse(purchaseDto.purchase_date())));
        }


        // Merchant order y código descuento
        if (purchaseDto.merchant_order() != null) {
            existingCompra.setMerchant_order(purchaseDto.merchant_order());
        }
        if (purchaseDto.discount_code() != null) {
            existingCompra.setCodigo_descuento(purchaseDto.discount_code());
        }

        // Actualizar usuario si viene user_id válido
        if (purchaseDto.user_id() != null && !purchaseDto.user_id().isEmpty()) {
            Integer userId = Integer.parseInt(purchaseDto.user_id());
            Usuario usuario = usuarioRepository.findById(userId)
                    .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + userId));
            existingCompra.setUsuario(usuario);
        }

        // Actualizar curso (considerando que Compra tiene lista cursos)
        if (purchaseDto.course_id() != null && !purchaseDto.course_id().isEmpty()) {
            Integer courseId = Integer.parseInt(purchaseDto.course_id());
            Curso curso = cursoRepository.findById(courseId)
                    .orElseThrow(() -> new EntityNotFoundException("Curso no encontrado: " + courseId));

            // Suponiendo que sólo quieres mantener 1 curso en la compra (o reemplazar lista)
            existingCompra.setCursos(List.of(curso));
        }

        System.out.println("Actualizando compra: " + purchaseDto);
        return compraRepository.save(existingCompra);
    }


}
