package com.militar.rest.AMB_DASHBOARD.service;

import com.militar.rest.AMB_DASHBOARD.dto.user.GetUserDto;
import com.militar.rest.AMB_DASHBOARD.dto.user.GetUserList;
import com.militar.rest.AMB_DASHBOARD.dto.user.GetUserNameSo;
import com.militar.rest.AMB_DASHBOARD.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

    public GetUserNameSo getUserByName() {

        return GetUserNameSo.from(usuarioRepository.findAll());

    }


}
