package com.bank.ojbank.service;

import com.bank.ojbank.model.Usuario;
import com.bank.ojbank.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario criarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }
    public List<Usuario> listarUsuarios() {
    return repository.findAll();
    }
}
