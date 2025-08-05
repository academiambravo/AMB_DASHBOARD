package com.militar.rest.AMB_DASHBOARD.service;

import com.militar.rest.AMB_DASHBOARD.dto.course.GetCourseDto;
import com.militar.rest.AMB_DASHBOARD.dto.purchase.GetPurchaseDto;
import com.militar.rest.AMB_DASHBOARD.dto.purchase.GetPurchaseList;
import com.militar.rest.AMB_DASHBOARD.dto.user.GetUserDto;
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

import java.util.List;

@Service
@AllArgsConstructor
public class CompraService {

    private final CompraRepository compraRepository;
    private final CursoRepository cursoRepository;
    private final UsuarioRepository usuarioRepository;

    public GetPurchaseDto getUserById(Integer userId) {
        return compraRepository.findById(userId)
                .map(GetPurchaseDto::from)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
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

        existingCompra.setPrecio_compra(purchaseDto.purchase_price());
        existingCompra.setFecha_compra(purchaseDto.purchase_date());

        if (purchaseDto.user_id() == null || purchaseDto.user_id().isEmpty()) {
            throw new IllegalArgumentException("El user_id no puede ser null o vacío");
        }

        Integer userId = Integer.parseInt(purchaseDto.user_id());
        Usuario usuario = usuarioRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + userId));
        existingCompra.setUsuario(usuario);

        return compraRepository.save(existingCompra);
    }


}
