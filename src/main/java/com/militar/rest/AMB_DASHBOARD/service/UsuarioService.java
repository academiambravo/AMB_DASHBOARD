package com.militar.rest.AMB_DASHBOARD.service;

import com.militar.rest.AMB_DASHBOARD.dto.user.GetUserDto;
import com.militar.rest.AMB_DASHBOARD.dto.user.GetUserList;
import com.militar.rest.AMB_DASHBOARD.dto.user.GetUserNameSo;
import com.militar.rest.AMB_DASHBOARD.model.Usuario;
import com.militar.rest.AMB_DASHBOARD.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    public GetUserDto getUserById(Integer id) {

        if(usuarioRepository.findById(id).isPresent())
            return GetUserDto.from(usuarioRepository.findById(id).get());

        throw new EntityNotFoundException("User not found with id: " + id);

    }

    public GetUserList getUserList () {

        if(usuarioRepository.findAll().isEmpty())
            throw new EntityNotFoundException("No users found");

        return GetUserList.from(usuarioRepository.findAll());
    }

    public void deleteUserById(Integer id) {

        usuarioRepository.deleteById(id);
    }

    public List<GetUserNameSo> getUserByName() {
        return usuarioRepository.findAll()
                .stream()
                .map(GetUserNameSo::from)
                .toList();
    }

    public Usuario updateUsuario(GetUserDto newUser, Integer id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        usuario.setCorreo(newUser.correo());
        usuario.setContrasena(newUser.contrasena());
        usuario.setNombre(newUser.nombre());
        usuario.setApellidos(newUser.apellidos());
        usuario.setNombre_completo(newUser.nombre_completo());
        usuario.setAno_nacimiento(newUser.ano_nacimiento());
        usuario.setPrefijo(newUser.prefijo());
        usuario.setTelefono(newUser.telefono() != null ? Integer.valueOf(newUser.telefono()) : null);
        usuario.setDireccion(newUser.direccion());
        usuario.setApodo(newUser.apodo());
        usuario.setFoto(newUser.foto());
        usuario.setGenero(newUser.genero());
        usuario.setFecha_creacion(newUser.fecha_creacion());
        usuario.setUltimo_acceso(newUser.ultimo_acceso());
        usuario.setDiscord(newUser.discord());
        usuario.setIdent_fiscal(newUser.ident_fiscal());
        usuario.setVerificado(newUser.verificado());
        usuario.setFecha_examen(newUser.fecha_examen());
        usuario.setAciertos_examen(newUser.aciertos_examen() != null ? Integer.valueOf(newUser.aciertos_examen()) : null);
        usuario.setBaremo(newUser.baremo());

        return usuarioRepository.save(usuario);
    }


}
